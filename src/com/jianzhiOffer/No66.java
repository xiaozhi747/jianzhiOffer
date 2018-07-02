package com.jianzhiOffer;

/**
 * 构建乘积数组
 * <p>
 * 给定一个数组 A[0,1,...,n−1]，请构建一个数组 B[0,1,...,n−1]。
 * 其中 B 中的元素 B[i]=A[0]∗ A[1] ∗...∗ A[i−1]∗A[i+1] ∗ ... ∗A[n−1]。 不能使用除法。
 * <p>
 * Created by 林智 on 2018/7/2.
 */
public class No66 {

    public static int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] res = new int[A.length];
        // 由于初始时每个 res数组里的值都是0,
        // 所以应当采用赋值的方式计算出前半部分的值,
        // 用累乘的方式计算出后半部分的值
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = A[i - 1] * res[i - 1];
        }
        int temp = 1;
        for (int j = res.length - 2; j >= 0; j--) {
            temp *= A[j + 1];
            res[j] *= temp;
        }
        return res;
    }

    public static void main(String[] args) {
        multiply(new int[]{1,2,3,4,5});
    }

}
