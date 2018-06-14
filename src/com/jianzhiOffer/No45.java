package com.jianzhiOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 把数组排成最小的数
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * Created by 林智 on 2018/6/14.
 */
public class No45 {

    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        list.sort(new MinNumberComparator());
        StringBuilder sb = new StringBuilder();
        for (int s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    public class MinNumberComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            // 整道题的关键在于如何确定一个得到贪心策略, 然后进行排序
            // 而要使数组中每个数合起来后的值最小, 那么先找出如何判断2个数谁应该排前面
            // 而判断的方法就是 o1o2 与 o2o1 比较, 乘积小的数, 前面的值小,
            // 即假设 o1o2 < o2o1, 那么我们认为 o1 小于 o2, o1 应该排在 o2 前面
            String str1 = o1 + "" + o2;
            String str2 = o2 + "" + o1;
            return str1.compareTo(str2);
        }
    }
}
