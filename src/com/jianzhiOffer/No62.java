package com.jianzhiOffer;

import java.util.LinkedList;

/**
 * 圆圈中最后剩下的数字
 *
 * 0，1，'''，n-1这n 个数字排成一个圆圈，从数字0开始每次从这个圆圈中删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字.
 *
 * Created by 林智 on 2018/7/1.
 */
public class No62 {

    /**
     * 用链表模仿圆圈的解, 时间复杂度 O(nm) 空间复杂度 O(n)
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int current = 0;
        while (list.size() > 1) {
            for (int i = 1; i < m; i++) {
                current++;
                if (current == list.size()) {
                    current = 0;
                }
            }
            list.remove(current);
            // 当删除的节点为最后一个节点的时候, current应当更新为第一个节点的索引值
            if (current == list.size()) {
                current = 0;
            }
        }
        return list.get(current);
    }

    /**
     * 最优解, 根据规律推导出数学公式
     * 时间复杂度 O(n)
     */
    public int LastRemaining_Solution2(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;

        }
        return last;
    }

    /**
     * 也是一个不错的解
     */
    public int LastRemaining_Solution3(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }

}
