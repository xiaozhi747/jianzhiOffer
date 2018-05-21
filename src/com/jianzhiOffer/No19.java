package com.jianzhiOffer;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * 注: 题不难, 但是需要注意很多细节, 比如 if 语句的条件顺序, 括号
 *
 * Created by 林智 on 2018/5/19.
 */
public class No19 {

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);
    }

    private boolean matchCore(char[] str, char[] pattern, int si, int pi) {
        if (si == str.length && pi == pattern.length) {
            return true;
        }
        // 注意条件
        if (si != str.length && pi == pattern.length) {
            return false;
        }
        if (pi + 1 < pattern.length && pattern[pi + 1] == '*') {
            // 注意条件顺序, 括号
            if (str.length != si && (str[si] == pattern[pi]
                    || pattern[pi] == '.')) {
                return matchCore(str, pattern, si + 1, pi + 2)
                        || matchCore(str, pattern, si, pi + 2)
                        || matchCore(str, pattern, si + 1, pi);
            } else {
                return matchCore(str, pattern, si, pi + 2);
            }
        }
        // 注意条件顺序, 括号
        if (str.length != si && (str[si] == pattern[pi]
                || pattern[pi] == '.')) {
            return matchCore(str, pattern, si + 1, pi + 1);
        }
        return false;
    }
}
