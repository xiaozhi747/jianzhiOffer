package com.jianzhiOffer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 *
 * Created by 林智 on 2018/5/15.
 */
public class No10 {
    /**
     * 非递归版
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        // 注意这里的初始值, 不应该是 n-1 或 n-2
        int preOne = 1;
        int preTwo = 0;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }

    /**
     * 递归版
     * @param n
     * @return
     */
    public static int Fibonacci2(int n) {
        if (n < 2) {
            return n;
        }
        return Fibonacci2(n - 1) + Fibonacci2(n - 2);

    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++){
            if (Fibonacci2(i) != Fibonacci(i)){
                System.out.println("failed");
            }
        }
    }
}
