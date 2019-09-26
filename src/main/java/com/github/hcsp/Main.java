package com.github.hcsp;

public class Main {
    static String sign;//定义静态成员变量，则下面只赋值即可，不需要String定义了
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
            sign = ">";
        } else if (a < b) {
            sign = "<";//在此时才定义sign变量
        } else {
            sign = "=";
        }
        return "" + a + sign + b;
    }
}
