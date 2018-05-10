package com.jianzhiOffer;
/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 *
 * Created by 林智 on 2018/5/10.
 */
public class No3 {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false

    /**
     * 时间复杂度 O(n) 空间复杂度O(n)
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (i != numbers[i]) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                } else {
                    swap(numbers, i, numbers[i]);
                }
            }
        }
        return false;
    }

    public void swap(int numbers[], int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    /**
     * 面试题 3 的题目 2
     * 在一个长度为 n+1 的数组里所有的数字都在 1~n 的范围内,所以数组中至少有一个数字是重复的.
     *  请找出数组中任意一个重复的数字, 但不能修改输入的数组. 列入输入长度为 8 的
     *  数组 {2, 3, 5, 4, 3, 2, 6, 7}, 那么对应的输出是重复的数字 2 或 3
     *
     * 该算法并不能保证找出所有重复的数字, 例如重复的数字2就找不出来,这是因为在 1~2 的范围
     * 里有1和2两个数字,这个范围的数字也出现 2 次.
     * 时间复杂度 O(nlogn) 空间复杂度 O(1)
     */
    public static int getDuplication(int numbers[],int length) {
        if (numbers == null || length <= 0) {
            return -1;
        }
        int start = 1;
        int end = length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(numbers, length, start, middle);
            if (start == end) {
                if (count > 1) {
                    return start;
                }else{
                    break;
                }
            }
            if (count > (middle - start + 1)) {
                end = middle;
            } else{
                start = middle + 1;
            }
        }

        return -1;
    }

    public static int countRange(int[] numbers, int length, int start, int end) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= start && numbers[i] <= end) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(getDuplication(numbers, numbers.length));
    }
}
