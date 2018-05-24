package com.jianzhiOffer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 *  1  2  3  4
 *  5  6  7  8
 *  9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * Created by 林智 on 2018/5/24.
 */
public class No29 {

    static ArrayList<Integer> resultList = new ArrayList<Integer>();

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int x1 = 0;
        int y1 = 0;
        int x2 = matrix.length - 1;
        int y2 = matrix[0].length - 1;
        System.out.println(x1);
        System.out.println(y1);
        System.out.println(x2);
        System.out.println(y2);
        while (x1 <= x2 && y1 <= y2) {
            printEdge(matrix, x1++, y1++, x2--, y2--);
        }
        return resultList;
    }

    private static void printEdge(int[][] matrix, int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            // 注意条件
            while (y1 <= y2) {
                resultList.add(matrix[x1][y1++]);
            }
        } else if (y1 == y2) {
            // 注意条件
            while (x1 <= x2) {
                resultList.add(matrix[x1++][y1]);
            }
        } else {
            int curI = x1;
            int curJ = y1;
            while (curJ != y2) {
                resultList.add(matrix[x1][curJ]);
                curJ++;
            }
            while (curI != x2) {
                resultList.add(matrix[curI][y2]);
                curI++;
            }
            while (curJ != y1) {
                resultList.add(matrix[x2][curJ]);
                curJ--;
            }
            while (curI != x1) {
                resultList.add(matrix[curI][y1]);
                curI--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1}};
        ArrayList<Integer> list = printMatrix(arr);
        System.out.println(list.toString());
    }
}
