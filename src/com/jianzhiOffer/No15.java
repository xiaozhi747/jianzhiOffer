package com.jianzhiOffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * Created by 林智 on 2018/5/18.
 */
public class No15 {

    /**
     * 最优解,同时也是递归解法
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        int n = Math.abs(exponent);
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return base;
        }
        // exponent 每次都除 2
        double result = Power(base, n >> 1);
        result *= result;
        // 如果 exponent 是奇数, 则要再乘一次 base
        if ((n & 1) == 1) {
            result *= base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    /**
     * 次优解
     * @param base
     * @param exponent
     * @return
     */
    public static double Power2(double base, int exponent) {
        // 是否是非法输入
        boolean invalidInput = false;
        if (equal(base, 0.0) && exponent < 0) {
            invalidInput = true;
            return 0;
        }
        int n = Math.abs(exponent);
        double result = 1.0;
        for (int i = 1; i <= n; i++) {
            result *= base;
        }
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }

    static boolean equal(double num1,double num2){
        if(num1 - num2 > -0.000001 && num1 - num2 < 0.000001){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(Power2(i, i + 5));
        }
    }
}
