package com.jianzhiOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * Created by 林智 on 2018/6/5.
 */
public class No40 {

    /**
     * 利用大根堆来解
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (input == null || input.length == 0 || k > input.length || k <= 0) {
            return list;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(k, new DescendingComparator());
        for (int i = 0; i < input.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(input[i]);
            } else if (priorityQueue.peek() > input[i]) {
                priorityQueue.poll();
                priorityQueue.add(input[i]);
            }
        }
        System.out.println(priorityQueue.poll());
        while (priorityQueue.size() > 0) {
            list.add(priorityQueue.poll());
        }
        return list;
    }

    /**
     * 降序排序比较器
     */
    public static class DescendingComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;  // o2.compareTo(o1)
        }
    }

    public static void main(String[] args) {
        int[] array = {4,5,1,6,2,7,3,8};
        GetLeastNumbers_Solution(array, 4);
    }
}


