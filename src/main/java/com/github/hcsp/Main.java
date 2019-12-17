package com.github.hcsp;

import java.text.MessageFormat;

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
        if (a > b) {
            String sign = ">";
            String result = MessageFormat.format("a{0}b", sign);
            return result;
        } else if (a < b) {
            String sign = "<";
            String result = MessageFormat.format("a{0}b", sign);
            return result;
        } else {
            String sign = "=";
            String result = MessageFormat.format("a{0}b", sign);
            return result;
        }
    }
}
