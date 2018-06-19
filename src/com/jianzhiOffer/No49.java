package com.jianzhiOffer;

/**
 * 丑数
 *
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 *
 * Created by 林智 on 2018/6/19.
 */
public class No49 {

    public static int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int p1 = 0, p2 = 0, p3 = 0;
        int[] res = new int[index];
        res[0] = 1;
        for (int i = 1; i < index; i++) {
            res[i] = min(res[p1] * 2, res[p2] * 3, res[p3] * 5);
            if (res[i] == res[p1] * 2) {
                p1++;
            }
            if (res[i] == res[p2] * 3) {
                p2++;
            }
            if (res[i] == res[p3] * 5) {
                p3++;
            }
            System.out.println(res[i]);
        }

        return res[index - 1];
    }

    private static int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }

    public static void main(String[] args) {
        GetUglyNumber_Solution(11);
    }

}
