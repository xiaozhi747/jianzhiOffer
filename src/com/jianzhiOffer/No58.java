package com.jianzhiOffer;

/**
 * 题目一：翻转单词顺序
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串 "I am a student."，则输出 "student. a am I"
 *
 * Created by 林智 on 2018/6/26.
 */
public class No58 {

    /**
     * 题目一
     */
    public static String ReverseSentence(String str) {
        if (str == null || str.trim().equals("")) {
            return str;
        }
        char[] chs = str.toCharArray();
        reverse(chs, 0, chs.length - 1);
        int start = 0;
        int end = 0;
        while (start < chs.length) {
            if (chs[start] == ' ') {
                start++;
                end++;
            } else if (end == chs.length || chs[end] == ' ') {
                reverse(chs, start, --end);
                start = ++end;
            } else { // 当 start 到了某个单词的第一个字母的位置上时, 就是这种情况
                end++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chs.length; i++) {
            sb.append(chs[i]);
        }
        return sb.toString();
    }

    private static void reverse(char[] chs, int start, int end) {
        while (start < end) {
            char temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence(" I am a student."));
        System.out.println(ReverseSentence("Wonderful"));
    }
}
