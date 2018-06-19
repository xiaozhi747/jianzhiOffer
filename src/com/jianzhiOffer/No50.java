package com.jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 *
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 *
 * Created by 林智 on 2018/6/19.
 */
public class No50 {

    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        char[] chs = str.toCharArray();
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < chs.length; i++) {
            if (!hashMap.containsKey(chs[i])) {
                hashMap.put(chs[i], 1);
            } else {
                hashMap.put(chs[i], hashMap.get(chs[i]) + 1);
            }
        }
        for (int i = 0; i < chs.length; i++) {
            if (hashMap.get(chs[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

}
