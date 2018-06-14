package com.jianzhiOffer;

/**
 * 数字序列中某一位的数字
 * 数字以 0123456789101112131415... 的格式序列化到一个字符序列中.
 * 在这个序列中, 第5位（从 0 开始计数）是 5，第 13 位是 1，第 19 位是 4，等等。
 * 请写一个函数，求任意第 n 位对应的数字
 *
 * Created by 林智 on 2018/6/14.
 */
public class No44 {

    // 可以以书上的例子来理解这些代码
    public static int digitAtIndex(int indexN) {
        if (indexN < 0) {
            return -1;
        }
        int digits = 1;
        // 由于数字序列的长度是无限的, indexN是有限的, 所以必然存在一个解
        while (true) {
            int number = countOfInteger(digits);
            if (indexN < number * digits) {
                return digitAtIndex(indexN, digits);
            }
            indexN = indexN - number * digits;
            digits++;
        }
    }

    /**
     * 当我们知道要找的那一位数字位于某 N 位数之中后, 就可以用如下的方法找出那一位数字
     */
    private static int digitAtIndex(int indexN, int digits) {
        // indexN 在哪个数字上
        int number = beginNumber(digits) + indexN / digits;
        // 求出要将 number 除多少次才能将第 indexN 的值换到个位上
        int indexForRight = digits - indexN % digits;
        // 除 10 除到 indexN 在数字上的位置变为个位时就停, 然后取余得到这个个位数
        for (int i = 1; i < indexForRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    /**
     *
     * @param digit
     * @return 返回 digit 位的数字总共有多少个, 例如输入 2, 则返回两位数(10~99)的个数 90 个
     */
    private static int countOfInteger(int digit) {
        if (digit == 1) {
            return 10;
        }
        int result = (int) Math.pow(10, digit - 1);
        return 9 * result;
    }

    /**
     *
     * @param digits
     * @return 返回 digits 位数的第一个数字, 例如第一个两位数的第一个数字是 10, 第一个三位数则是 100
     */
    private static int beginNumber(int digits) {
        if (digits == 1) {
            return 0;
        }
     /*   int result = 1;
        for (int i = 1; i <= digits; i++) {
            result *= 10;
        }
        return result;*/
        return (int) Math.pow(10, digits - 1);
    }

    public static void main(String[] args) {
        System.out.println(digitAtIndex(1001));
    }
}
