package com.jianzhiOffer;

/**
 * 把数字翻译成字符串
 *
 * 给定一个数字，按照如下规则翻译成字符串：0翻译成“a”，1翻译成“b”...25翻译成“z”。
 * 一个数字有多种翻译可能，例如12258一共有5种，分别是bccfi，bwfi，bczi，mcfi，mzi。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 * Created by 林智 on 2018/6/15.
 */
public class No46 {

    public static int getTranslationCount(int number) {
        if (number < 0) {
            return 0;
        }
        String str = number + "";
        char[] charStr = str.toCharArray();
        return getTranslationCount(charStr, 0);
    }

    public static int getTranslationCount(char[] str, int index) {
        if (index == str.length) {
            return 1;
        }
        if (str[index] == '0') {
            return 0;
        }
        if (str[index] == '1' && index + 1 < str.length) {
            return getTranslationCount(str, index + 2) + getTranslationCount(str, index + 1);
        }
        if (str[index] == '2' && (str[index + 1] >= '0' && str[index + 1] <= '6')
                && index + 1 < str.length) {
            return getTranslationCount(str, index + 2) + getTranslationCount(str, index + 1);
        }
        return getTranslationCount(str, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(getTranslationCount(12345));
        System.out.println(getTranslationCount(12258));
    }

}
