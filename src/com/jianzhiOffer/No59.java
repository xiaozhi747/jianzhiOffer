package com.jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目一：滑动窗口的最大值
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 *
 * 题目二：队列的最大值
 *
 * 请定义一个队列并实现函数 max 得到队列里的最大值, 要求函数 max、push_bac 和 pop_front
 * 的时间复杂度都是 O(1)
 *
 *
 * Created by 林智 on 2018/6/28.
 */
public class No59 {

    /**
     * 题目一
     */
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (num == null || num.length == 0 || size <= 0) {
            return res;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < num.length; i++) {
            while(!queue.isEmpty() && num[i] >= num[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.peekFirst() == i - size) {
                queue.pollFirst();
            }
            if (i >= size - 1) {
                res.add(num[queue.peekFirst()]);
                System.out.println(num[queue.peekFirst()]);
            }
        }
        return res;
    }

    LinkedList<Integer> dataQueue = new LinkedList<Integer>();
    LinkedList<Integer> maxQueue = new LinkedList<Integer>();

    /**
     * 题目二
     *
     * 插入队列尾部
     */
    public void push_back(int number) {
        dataQueue.addLast(number);
        while (!maxQueue.isEmpty() && number > maxQueue.peekLast()) {
            maxQueue.pollLast();
        }
        maxQueue.addLast(number);
    }

    /**
     * 从队列头部弹出
     */
    public void pop_front() {
        if (!dataQueue.isEmpty()) {
            if (maxQueue.peekFirst() == dataQueue.peekFirst()) {
                maxQueue.pollFirst();
            }
            dataQueue.pollFirst();
        }
    }

    /**
     * 获取队列中的最大值
     */
    public int max() {
        if (!maxQueue.isEmpty()) {
            return maxQueue.peekFirst();
        }
        return -1;
    }

    public static void main(String[] args) {
        maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3);
    }

}
