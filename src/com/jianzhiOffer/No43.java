package com.jianzhiOffer;

/**
 * 输入一个整数 n，求 1 ~ n 这 n 个正数的十进制表示中 1 出现的次数。
 * 例如，输入 12， 1 ~ 12 这些整数中包含 1 的数字中有 1、 10、11 和 12， 1 一共出现了 5 次
 *
 * Created by 林智 on 2018/6/13.
 */
public class No43 {

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) {
            return 0;
        }
        int len = getLenOfNum(n);
        if (len == 1) {
            return 1;
        }
        int temp = powerBaseOf10(len - 1);
        // 第一位数字的值
        int first = n / temp;
        // 1 在第一位上出现的次数
        int firstNum = first == 1 ? (n % temp) + 1 : temp;
        // 1 在其他位上出现的次数
        int otherNum = first * powerBaseOf10(len - 2) * (len - 1);
        return firstNum + otherNum + NumberOf1Between1AndN_Solution(n % temp);
    }

    private int powerBaseOf10(int base) {
        return (int) Math.pow(10, base);
    }

    private int getLenOfNum(int n) {
        int len = 0;
        while (n != 0) {
            len++;
            n /= 10;
        }
        return len;
    }
}
