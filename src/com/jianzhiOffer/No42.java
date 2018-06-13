package com.jianzhiOffer;

/**
 * 输入一个整型数组, 数组里有正数也有负数.
 * 数组中的一个或连续多个正数组成一个子数组.
 * 求所有子数组的和的最大值.
 * 要求时间复杂度为 O(n)
 *
 * Created by 林智 on 2018/6/13.
 */
public class No42 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (sum < 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
