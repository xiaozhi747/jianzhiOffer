package com.jianzhiOffer;

/**
 * 输入数字 n, 按顺序打印从 1 到最大的 n 位十进制数.
 * 比如输入 3, 则打印出 1、2、3 一直到最大的 3 位数 999
 *
 * 注: 解法二, 解法三都是可取的
 *
 * Created by 林智 on 2018/5/20.
 */
public class No17 {

    /**
     * 解法一:
     * 最简单的解法, 直接遍历
     * 但是这种解法没有考虑到大数的情况, 容易造成溢出, 所以这种解法不可取
     */
    void print1ToMaxOfNDigits_1(int n) {
        if (n <= 0) {
            return;
        }
        int number = 1;
        int i = 0;
        while (i++ < n) {
            number *= 10;
        }
        for (i = 1; i < number; i++) {
            System.out.println(i);
        }
    }

    /**
     * 在字符串上模拟数字加法的解法
     * @param n
     */
    void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        // 每次都判断将要打印的 number 值是否越界, 遍历 n位数最大值 次
        while (!increment(number)) {
            printNumber(number);
        }

    }

    /**
     * 解法二:
     * 每次调用都使得打印的数的值 +1,
     * 同时判断是否将要打印的 number 值是否越界(超过了 n 位数的最大值)
     * @param number
     * @return
     */
    private boolean increment(char[] number) {
        boolean isOverflow = false;
        int takeOver = 0;
        // i 从最后一位开始, 即从个位数开始
        for (int i = number.length - 1; i >= 0; i++) {
            int sum = number[i] + takeOver;
            if (i == number.length - 1) {
                sum++;
            }
            if (sum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                  sum -= 10;
                  takeOver = 1;
                  number[i] = 0;
                }
            } else {
                number[i] = (char)(sum);
                break;
            }
        }
        return isOverflow;
    }


    private void printNumber(char[] number) {
        boolean isBegin0 = true;
        for (int i = 0; i < number.length; i++) {
            if (isBegin0 && number[i] != 0) {
                isBegin0 = false;
            }
            if (!isBegin0){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    /**
     * 解法三:
     * 把问题转换为数字排列的解法, 递归实现
     * 思路:
     * 如果我们在数字前面补 0, 就会发现 n 位所有十进制数其实就是 n 个从 0 到 9 的全排列.
     * 也就是说,我们把数字的每一位都从 0 到 9 排列一遍, 就得到了所有的十进制数, 但是有一点
     * 需要注意, 排在前面的 0 不需要打印出来.
     *
     * 数字的每一位都可能是 0~9 中的一个数,然后设置下一位. 递归结束额条件是我们已经设置了
     * 数字的最后一位.
     *
     * @param n
     */
    void print1ToMaxOfNDigits2(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[0] = (char)i;
            print1ToMaxOfNDigits2Recursively(number, 0);
        }

    }

    void print1ToMaxOfNDigits2Recursively(char[] number, int index) {
        if (index == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char)i;
            print1ToMaxOfNDigits2Recursively(number, index + 1);
        }
    }
}
