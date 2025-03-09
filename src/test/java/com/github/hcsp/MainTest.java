package com.github.hcsp;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void relationTest() {
        Assertions.assertEquals("5<10", Main.relation(5, 10));
        Assertions.assertEquals("1>-1", Main.relation(1, -1));
        Assertions.assertEquals("0=0", Main.relation(0, 0));
    }

    @Test
    public void concurrentInvocationSafetyTest() throws ExecutionException, InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(100);
        ExecutorService threads = Executors.newCachedThreadPool();

        List<Future> futures =
                IntStream.range(0, 100)
                        .mapToObj(
                                (i) ->
                                        threads.submit(
                                                () -> {
                                                    Random random = new Random();
                                                    int a = random.nextInt(100);
                                                    int b = random.nextInt(100);
                                                    try {
                                                        cb.await();
                                                    } catch (InterruptedException
                                                             | BrokenBarrierException e) {
                                                        e.printStackTrace();
                                                    }
                                                    String relation = Main.relation(a, b);
                                                    Assertions.assertTrue(
                                                            relation.contains(
                                                                    a > b
                                                                            ? ">"
                                                                            : (a == b ? "=" : "<")),
                                                            () ->
                                                                    String.format(
                                                                            "Thread: %d, a: %d, b: %d, relation: %s",
                                                                            Thread.currentThread()
                                                                                    .getId(),
                                                                            a,
                                                                            b,
                                                                            relation));
                                                }))
                        .collect(Collectors.toList());
        for (Future future : futures) {
            future.get();
        }
    }
}
