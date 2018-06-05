package com.jianzhiOffer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 *
 * Created by 林智 on 2018/6/4.
 */
public class No39 {
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        // j 表示当前的 result 值出现的次数,
        // 如果当前的 j 值为 0, 则说明 result 应当更新为当前的 数组值
        int j = 1;
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (result != array[i]) {
                if (j <= 1) {
                    result = array[i];
                }
                if (j > 0) {
                    j--;
                }
            } else {
                j++;
            }
        }
        if (!checkMoreThanHalf(array, result)) {
            return 0;
        }
        return result;
    }

    private static boolean checkMoreThanHalf(int[] array, int number){
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                times++;
            }
        }
        if (times * 2 > array.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1,3,4,5,2,2,2,2,2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }
}
