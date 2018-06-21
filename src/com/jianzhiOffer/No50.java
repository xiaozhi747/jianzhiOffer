package com.jianzhiOffer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目一：第一个只出现一次的字符
 *
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 *
 *
 * 题目二：字符流中第一个只出现一次的字符
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * Created by 林智 on 2018/6/19.
 */
public class No50 {
    // 题目一
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


    Map<Character, Integer> linkedHashMap = new LinkedHashMap<Character, Integer>();

    // 题目二
    public void Insert(char ch) {
        if (!linkedHashMap.containsKey(ch)) {
            linkedHashMap.put(ch, 1);
        } else {
            linkedHashMap.put(ch, -1);
        }
    }

    // 题目二
    public char FirstAppearingOnce() {
        Iterator iterator = linkedHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Object key = entry.getKey();
            Object val = entry.getValue();
            if ((Integer)val != -1) {
                return (Character)key;
            }
        }
        return '#';
    }

    // 题目二使用数组实现的方法
    int[] hashtable=new int[256];
    StringBuffer s=new StringBuffer();
    public void Insert2(char ch) {
        s.append(ch);
        hashtable[ch]++;
    }

    // 题目二使用数组实现的方法
    public char FirstAppearingOnce2() {
        char[] str=s.toString().toCharArray();
        for(char c:str) {
            if(hashtable[c]==1) {
                return c;
            }
        }
        return '#';
    }
}
