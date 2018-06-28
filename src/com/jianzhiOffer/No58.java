package com.jianzhiOffer;

/**
 * 题目一：翻转单词顺序
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串 "I am a student."，则输出 "student. a am I"
 *
 *
 * 题目二：左旋转字符串
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串 "abcdefg" 和数字 2，
 * 该函数将返回左旋转两位得到的结果 "cdefgab".
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

    public String LeftRotateString(String str,int n) {
        if (str == null ) {
            return null;
        }
        if (n > str.length() || str.length() == 0 || n <= 0) {
            return str;
        }
        char[] chs = str.toCharArray();
        int firstPartStart = 0;
        int firstPartEnd = n - 1;
        int SecondPartStart = n;
        int SecondPartEnd = chs.length - 1;
        reverse(chs, firstPartStart, firstPartEnd);
        reverse(chs, SecondPartStart, SecondPartEnd);
        reverse(chs, 0, chs.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            sb.append(chs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence(" I am a student."));
        System.out.println(ReverseSentence("Wonderful"));
    }
}
