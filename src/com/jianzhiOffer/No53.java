package com.jianzhiOffer;

/**
 * 在排序数组中查找数字
 *
 * 统计一个数字在排序数组中出现的次数。
 * 例如：输入排序数组{1, 2, 3, 3, 3, 4, 5}和数字3，由于3在这个数组中出现了3次，因此输出3
 *
 * Created by 林智 on 2018/6/24.
 */
public class No53 {

    public static int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int firstK = getFirstK(array, k, 0, array.length - 1);
        int lastK = getLastK(array, k, 0, array.length - 1);
        int res = 0;
        // 这里要记得做判断, 不然找不到的时候会算出 1 这个错误的结果
        if (firstK > -1 && lastK > -1) {
            res = lastK - firstK + 1;
        }
        return res;
    }

    private static int getFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midValue = array[mid];
        if (k == midValue) {
            if ((mid > 0 && array[mid - 1] != k) || mid == 0) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (k > midValue) {
            start = mid + 1;
        } else { // k < midValue
            end = mid - 1;
        }
        return getFirstK(array, k, start, end);
    }

    private static int getLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midValue = array[mid];
        if (k == midValue) {
            if ((mid < array.length - 1 && array[mid + 1] != k)
                    || mid == array.length - 1) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (k > midValue) {
            start = mid + 1;
        } else { // k < midValue
            end = mid - 1;
        }
        return getLastK(array, k, start, end);
    }

    public static void main(String[] args) {
        System.out.println(GetNumberOfK(new int[]{1, 2, 3, 3, 3, 4, 5}, 3));
        System.out.println(GetNumberOfK(new int[]{1, 4, 4, 4, 4, 4, 5}, 2));
        System.out.println(GetNumberOfK(new int[]{1, 2, 3, 3, 3, 5, 5}, 5));
        System.out.println(GetNumberOfK(new int[]{1, 2, 3, 3, 3, 4, 5}, 2));
    }
}
