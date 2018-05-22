package com.jianzhiOffer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * Created by 林智 on 2018/5/21.
 */
public class No20 {

    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        // 判断前面 . 符号前面是否是数字
        boolean isNumeric = scanInteger(str);
        // 如果出现 '.', 则接下来是小数部分
        if (index < str.length && str[index] == '.') {
            index++;

            // 下面一行代码用 || 的原因:
            // 1. 小数可以没有证书部分, 如 .123 等于 0.123
            // 2. 小数点后面可以没有数字, 如 233. 等于 233.0
            // 3. 当然, 小数点前面和后面可以都有数字, 如 233.666
            // 注意 || 前面为 true 后, 后面的逻辑就不跑了, 所以要判断好哪个逻辑在前.
            // 这个坑要记住, 这个坑导致看了很久都没发现问题, 最后通过 debug 才发现的.
            isNumeric = scanUnsignedInteger(str) || isNumeric ;
        }
        // 如果出现 'e' 或者 'E', 则接下来是数字的指数部分
        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;

            // 下面一行代码用 && 的原因:
            // 1. 当 e 或 E 前面没有数字时, 整个字符串不能表示数字, 如 .e1 、 e1
            // 2. 当 e 或 E 后面没有整数时, 整个字符串不能表示数字, 如 12e 、 12e+5.4
            isNumeric = isNumeric && scanInteger(str);
        }
        return isNumeric && index == str.length;
    }

    /**
     * 用于扫描字符串中可能以 '+' 或者 '-' 为起始的 0~9 的数位（类似于一个可能带正负符号的整数）
     * @param str
     * @return
     */
    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }

    /**
     * 用于扫描字符串中的 0~9 的数位（类似于一个无符号整数）
     * @param str
     * @return
     */
    private boolean scanUnsignedInteger(char[] str) {
        int startIndex = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        // 当 str 中存在若干 0~9 的数字时, 返回 true
        return index > startIndex;
    }

    public static void main(String[] args) {
        char[] str = {'1','2','3','.','4','5','e','+','6'};
        char[] str2 = {'+','5','0','0'};
        // 注意: 测试的时候添加的 static 参数, 在跑 oj 的时候是无法通过多个测试用例的,
        // 因为带有 static 关键字的 index, 每次跑完之后都不会初始回 0 值;
        // 所以在此处把测试代码注释掉了, 有需要可以打开
        //System.out.println(isNumeric(str2));
    }
}
