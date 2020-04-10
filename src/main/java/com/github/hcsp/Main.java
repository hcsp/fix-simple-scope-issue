package com.github.hcsp;
public class Main {
    public static String sign;
    //在这里也可以，反正要大于return，不过鉴于结构清晰，肯定放他自己的函数中
    public static void main(String[] args) {
        System.out.println(relation(1, 2));
        System.out.println(relation(2, 1));
        System.out.println(relation(2, 2));
    }
    public static String relation(int a, int b) {
//        String sign;   sign在if外面定义就行，要不然return里的sign没用。
        if (a > b) {
             sign = ">";
        } else if (a < b) {
             sign = "<";
        } else {
             sign = "=";
        }
        return "" + a + sign + b;
    }
}
