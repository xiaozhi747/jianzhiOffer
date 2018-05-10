package com.jianzhiOffer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * Created by 林智 on 2018/5/10.
 */
public class No4 {

    public boolean Find(int target, int [][] array) {
        if (target < 0 || array == null || array.length == 0) {
            return false;
        }
        int row = array.length - 1;
        int col = 0;
        while (col < array[0].length && row > -1) {
            if (array[row][col] == target) {
                return true;
            } else if (array[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }

        return false;
    }

}
