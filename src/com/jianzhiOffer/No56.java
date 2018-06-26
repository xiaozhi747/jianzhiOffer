package com.jianzhiOffer;

/**
 * 题目一：数组中只出现一次的两个数字
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是 O(n), 空间复杂度是 O(1)
 *
 * Created by 林智 on 2018/6/25.
 */
public class No56 {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        int resultExclusiveOR = 0;
        for (int i = 0; i < array.length; i++) {
            resultExclusiveOR ^= array[i];
        }
        int indexOf1 = findFirstBitIs1(resultExclusiveOR);
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if (IsBit1(array[i], indexOf1)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * 判断在 number 的二进制表示中从右边数起的 indexBit 位是不是 1
     */
    private boolean IsBit1(int number, int indexBit) {
        number = number >> indexBit;
        return (number & 1) == 1;
        /*if ((number & 1) == 1) {
            return true;
        } else {
            return false;
        }*/
    }

    /**
     * 用来在整数 number 的二进制表示中找到最右边是 1 的位
     */
    private int findFirstBitIs1(int number) {
        int indexBit = 0;
        while ((number & 1) == 0) {
            number = number >> 1;
            indexBit++;
        }
        return indexBit;
    }


}
