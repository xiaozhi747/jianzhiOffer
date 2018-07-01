package com.jianzhiOffer;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 *
 * 题目：从扑克牌中随机抽 5 张牌，判断是不是一个顺子，
 * 即这 5 张牌是不是连续的。2～10 为数字本身， A 为 1。 J 为 11、Q 为 12、 为 13。
 * 而大小王可以看成任意数字。  为了方便起见,你可以认为大小王是0。
 *
 * Created by 林智 on 2018/6/30.
 */
public class No61 {

    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        // 数组中 0 的个数, 也就是大小王的个数
        int numberOfZero = 0;
        // 数组中包含的间隙, 比如连续的牌他们的间隙为 0
        int numberOfGap = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
            numberOfZero++;
        }
        // big 即为 small 后面的那个值, 通过 small 和 big 来求间隙
        // 假如 0 的数字有 2 个, 那么我们应该从第三个位置开始往后遍历,
        // 也就是索引 2, 刚好也就是 numberOfZero 的值
        // 直接从大于 0 的值开始遍历
        int small = numberOfZero;
        int big = small + 1;
        while (big < numbers.length) {
            if (numbers[big] == numbers[small]) {
                return false;
            }
            // 如果是连续的值, 那么求出来的间隙就为 0, 否则必然大于 0
            numberOfGap += numbers[big] - numbers[small] - 1;
            small++;
            big = small + 1;
        }
        return numberOfGap > numberOfZero ? false : true;
    }

}
