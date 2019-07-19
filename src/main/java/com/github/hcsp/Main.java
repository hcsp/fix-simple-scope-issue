package com.github.hcsp;

import jdk.nashorn.internal.runtime.Undefined;

public class Main {
    public static void main(String[] args) {
        System.out.println(relation(1, 2));
        System.out.println(relation(2, 1));
        System.out.println(relation(2, 2));
    }

    // Fix the compilation error
    // Return "a<b" if a < b, "a>b" if a > b, "a=b" otherwise
    // 修复编译错误
    // 在a<b时返回字符串"a<b"，在a>b时返回字符串"a>b"，否则返回"a=b"
    public static String relation(int a, int b) {
        String sign;
//        String sign = null;
//        String sign = "";
        if (a > b) {//我在这一行打断点，发现 String sign; sign 并没有被创建，Sting sign = null;和Sting sign = ""; 分别创建了 sign = null ; sign = "";
            sign = ">";
        } else if (a < b) {
            sign = "<";
        } else {
            sign = "=";
        }

        return "" + a + sign + b;
    }
}
