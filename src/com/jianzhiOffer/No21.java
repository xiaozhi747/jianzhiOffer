package com.jianzhiOffer;

/**
 * 基础问题:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
 *
 * 进阶问题 (附加条件限制):
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * Created by 林智 on 2018/5/22.
 */
public class No21 {
    /**
     * 基础问题的解
     */
    public void reOrderArray2(int [] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int beginI = 0;
        int endI = array.length - 1;
        while (beginI < endI) {
            // 遇到偶数就停
            while (beginI < endI && !isEven(array[beginI])) {
                beginI++;
            }
            // 遇到奇数就停
            while (beginI < endI && isEven(array[endI])) {
                endI--;
            }
            if (beginI < endI) {
                swap(array, beginI, endI);
            }
        }
    }

    /**
     *  判断是否是偶数
     */
    boolean isEven(int n) {
        return (n & 1) == 0;
    }

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 进阶问题的解
     * 由于要保证稳定即证奇数和奇数，偶数和偶数之间的相对位置不变 使用插入排序思想
     * 以 1 2 2 3 3 4 4 5 5 7 作为例子就能够很好的理解下面这段代码
     */
    public void reOrderArray(int [] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            // 如果 array[i] 是奇数
            if (array[i] % 2 == 1) {
                int temp = array[i];
                int j = i - 1;
                while (j >= 0 && array[j] % 2 == 0) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = temp;
            }
        }
    }





}
