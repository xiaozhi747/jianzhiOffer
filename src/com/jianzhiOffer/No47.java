package com.jianzhiOffer;

/**
 * 礼物的最大价值
 *
 * 在一个m*n的棋盘的每一个格都放有一个礼物，每个礼物都有一定价值（大于0）。
 * 从左上角开始拿礼物，每次向右或向下移动一格，直到右下角结束。给定一个棋盘，求拿到礼物的最大价值。
 * 例如，对于如下棋盘
 *     1    10   3    8
 *     12   2    9    6
 *     5    7    4    11
 *     3    7    16   5
 *  礼物的最大价值为 1+12+5+7+7+16+5=53。
 *
 * Created by 林智 on 2018/6/15.
 */
public class No47 {

    /**
     * 递归的方法暂时不实现, 更优解未来会实现
     * 本解法的是以二维数组做为空间代价的, 还存在更优解, 即使用一位数组作为空间代价
     */
    public int getMaxValueSolution1(int[][] number) {
        if (number == null || (number.length == 0 && number[0].length == 0)) {
            return 0;
        }
        int row = number.length;
        int col = number[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = number[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + number[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + number[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int up = dp[i][j - 1];
                int left = dp[i - 1][j];
                dp[i][j] = Math.max(up, left) + number[i][j];
            }
        }
        int maxValue = dp[row - 1][col - 1];
        return maxValue;
    }
}
