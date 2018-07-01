package com.jianzhiOffer;

/**
 * 股票的最大利润
 *
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可获得的最大利润是多少？
 *
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。
 * 如果我们能在价格为5的时候买入并在价格为16时卖出，则能获得最大的利润为11.
 *
 * Created by 林智 on 2018/7/1.
 */
public class No63 {

    /**
     * 思路: 以每个位置为结尾, 求每个位置的最大股票利润, 答案必定在其中
     */
    public int maxDiff(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return 0;
        }
        int min = numbers[0];
        int max = 0;
        for (int i = 1; i < numbers.length; i++) {
            max = Math.max(numbers[i] - min > 0 ? numbers[i] - min : 0, max);
            min = Math.min(min, numbers[i]);
        }
        return max;
    }

}
