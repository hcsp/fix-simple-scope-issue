package com.github.hcsp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    public void relationTest() {
        assertEquals("5<10", Main.relation(5, 10));
        assertEquals("1>-1", Main.relation(1, -1));
        assertEquals("0=0", Main.relation(0, 0));
    }
}
