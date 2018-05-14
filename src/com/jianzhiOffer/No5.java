package com.jianzhiOffer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成 “%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为 We%20Are%20Happy。
 *
 * Created by 林智 on 2018/5/10.
 */
public class No5 {

    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        int numberOfBlank = 0; // 字符串中空格的数量
        int length = str.length() - 1;
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                numberOfBlank++;
            }
        }
        int newLength = str.length() + numberOfBlank * 2;
        StringBuffer sb = new StringBuffer(newLength);
        while (length >= 0) {
            if (str.charAt(length) == ' '){
                sb.insert(0,"0");
                sb.insert(0,"2");
                sb.insert(0,"%");
            } else {
              sb.insert(0, str.charAt(length));
            }
            length--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("hello world");
        System.out.println(replaceSpace(sb));
    }
}
