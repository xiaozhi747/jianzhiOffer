package com.jianzhiOffer;

/**
 * 不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 +、-、*、/ 四则运算符号。
 *
 * Created by 林智 on 2018/7/2.
 */
public class No65 {

    public static int Add(int num1,int num2) {
        int sum = 0;
        int carry = 0; // 进位
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            // 更新 num1、num2 的值继续做异或运算
            System.out.print(sum + " " + carry + "\n");
            num1 = sum;
            num2 = carry;
        } while (carry != 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Add(-7,5));
    }
}
