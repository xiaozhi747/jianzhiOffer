package com.jianzhiOffer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 *
 * Created by 林智 on 2018/5/16.
 */
public class No13 {


    /**
     *
     * @param threshold 题目中的 k
     * @param rows
     * @param cols
     * @return
     */
    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        return movingCountCore(threshold, 0, rows, 0, cols, visited);
    }

    /**
     *
     * @param threshold
     * @param row  当前的 行 值
     * @param rows
     * @param col  当前的 列 值
     * @param cols
     * @param visited  记录所有位置是否被访问过
     * @return
     */
    private static int movingCountCore(int threshold, int row, int rows,
                                int col, int cols, boolean[] visited) {
        int count = 0;
        if (check(threshold, row, rows, col, cols, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, row + 1, rows, col, cols, visited)
                    + movingCountCore(threshold, row - 1, rows, col, cols, visited)
                    + movingCountCore(threshold, row, rows, col + 1, cols, visited)
                    + movingCountCore(threshold, row, rows, col - 1, cols, visited);
        }
        return count;
    }

    private static boolean check(int threshold, int row, int rows,
                          int col, int cols, boolean[] visited){
        if (col >= 0 && col < cols && row >= 0 && row < rows
                && !visited[row * cols + col] && getDigitSum(col) + getDigitSum(row) <= threshold) {
            return true;
        }
        return false;
    }

    /**
     * @return 获取一个数的 所有位数和
     */
    private static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(5, 10, 10));
    }

}
