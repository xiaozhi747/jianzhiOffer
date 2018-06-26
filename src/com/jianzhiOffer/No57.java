package com.jianzhiOffer;

import java.util.ArrayList;

/**
 * 题目一：和为 s 的两个数字
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 *
 * 题目二：和为 s 的连续正数序列
 *
 * 输入一个正数 s, 打印出所有和为 s 的连续正数序列（至少含有两个数）。
 * 例如，输入 15, 由于 1+2+3+4+5=4+5+6=7+8=15, 所以打印出3个连续序列 1~5、4~6 和 7~8。
 *+
 * Created by 林智 on 2018/6/26.
 */
public class No57 {

    /**
     * 题目一
     *
     * 利用双指针的思路来解
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        // 牛客网的 oj 要求, 即使是非法的输入, 也应该返回 空的list
        if (array == null || array.length < 2) {
            return list;
        }
        int l = 0;
        int r = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (array[l] + array[r] == sum) {
                list.add(array[l]);
                list.add(array[r]);
                break;
            } else if (array[l] + array[r] > sum) {
                r--;
            } else { // array[l] + array[r] < sum
                l++;
            }
        }
        return list;
    }


    /**
     * 题目二
     *
     * 利用双指针的思路来解题, 与题目一的思路类似
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (sum < 3) {
            return resultList;
        }
        // 初始化小指针和大指针, 然后记录当前的和 curSum, 再去和目标 s 对比,如果相等则找到了一个解,
        // 若大于 s, 则缩小指针的范围, 使得 curSum 减小, 即 small 指针向后走;
        // 若小于 s, 则增大指针的范围, 使得 curSum 增大, 即 big 指针向后走
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;
        while (small < middle) {
            if (curSum == sum) {
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                resultList.add(list);
                list = new ArrayList<Integer>();
                big++;
                curSum += big;
            } else if (curSum < sum) {
                big++;
                curSum += big;
            } else { // curSum > sum
                curSum -= small;
                small++;
            }
        }
        return resultList;
    }

}
