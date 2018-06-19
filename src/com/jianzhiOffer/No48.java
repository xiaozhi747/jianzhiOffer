package com.jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 *
 * 输入一个字符串，找出字符串中最长的不含重复字符的子字符串，计算该子字符串的长度。
 * 假设字符串中的字符为“a~z”，例如 arabcacfr ，最长的字符串为 rabc 和 acfr ，长度为 4。
 *
 * Created by 林智 on 2018/6/18.
 */
public class No48 {
    /**
     * 过了 leetcode 的 oj
     *
     */
    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int distance = 0;   // 当前位置的字符上一次出现的位置 与 当前位置的距离
        int curLength = 0;  // 当前位置 最长不含重复字符的子字符串 的长度
        int max = 0;
        char[] chs = str.toCharArray();
        // 用于存放字符出现的最后一个位置
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < chs.length; i++) {
            // 如果该字符没出现过, 那么放入该字符,
            // 并且当前位置的 最长不含重复字符的子字符串 的长度是 (上一个位置的长度 + 1)
            if (!hashMap.containsKey(chs[i])) {
                hashMap.put(chs[i], i);
                curLength++;
                max = Math.max(curLength, max);
            } else {
                distance = i - hashMap.get(chs[i]);
                // 如果 当前位置的字符上一次出现的位置 与 当前位置的距离 大于上一个位置的长度,
                // 那么说明这个重复字符是不影响当前位置的最大长度的
                if (distance > curLength) {
                    curLength++;
                } else {  // distance <= curLength
                    // 如果 当前位置的字符上一次出现的位置 与 当前位置的距离 小于上一个位置的长度,
                    // 那么说明这个重复字符是影响当前位置的最大长度的, 并且当前位置的最
                    // 大长度就为距离 distance
                    curLength = distance;
                }
                max = Math.max(curLength, max);
                hashMap.put(chs[i], i);
            }
        }
        return max;
    }



    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("awertyauiopasdfghjklzxcvbnm"));
        System.out.println(lengthOfLongestSubstring("wertyuiopasdfghjklzaxcvbnm"));
    }

}
