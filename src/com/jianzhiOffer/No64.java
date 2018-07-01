package com.jianzhiOffer;

/**
 * 不用加减乘除做加法
 *
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条
 * 件判断语句（A?B:C）。
 *
 * Created by 林智 on 2018/7/1.
 */
public class No64 {

    /**
     * 正常的解
     */
    public int Sum_Solution(int n) {
        int res = n;
        // 如果 n > 1; 则后面部分那部分永远都会为 true
        boolean flag = (res > 0) && ((res += Sum_Solution(n - 1)) > 0);
        return res;
    }

    /**
     * 有趣的解
     */
    //用异常退出递归
    public int Sum_Solution2(int n) {
        return sum(n);
    }

    int sum(int n) {
        try {
            int i = 1 % n;
            return n + sum(n - 1);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int a = 0;
        // 在 java 里, 赋值完后是会有个返回值的, 返回值即为所赋值的值
        System.out.println(a = 1);
    }
}
