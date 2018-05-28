package com.jianzhiOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * Created by 林智 on 2018/5/28.
 */
public class No33 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySquenceOfBST(int [] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        int i = 0;
        for (; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int j = i;
        for (; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > 0) {
            left = VerifySquenceOfBST(sequence, start, i - 1);
        }
        boolean right = true;
        if (i < end - 1) {
            right = VerifySquenceOfBST(sequence, i, end - 1);
        }
        return right && left;
    }

}
