package com.jianzhiOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 *
 * 注意: 这其实也是 数学中的全排列 的代码写法
 * Created by 林智 on 2018/5/31.
 */
public class No38 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();
        if (str == null) {
            return result;
        }
        char[] strs = str.toCharArray();
        PermutationCore(strs, 0, result);
        Collections.sort(result);
        return result;
    }

    private void PermutationCore(char[] strs, int index, ArrayList<String> result) {
        if (index == strs.length - 1) {
            String str = String.valueOf(strs);
            if (!result.contains(str)){
                result.add(str);
            }
        } else {
            for (int i = index; i < strs.length; i++) {
                swap(strs, index, i);
                PermutationCore(strs, index + 1, result);
                swap(strs, index, i);

            }
        }
    }

    private void swap(char[] strs, int i, int j) {
        char temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }

}
