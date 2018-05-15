package com.jianzhiOffer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 *
 * 拓展:  在 JumpFloor() 实现了
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 拓展二: 在 JumpFloor() 实现, 解析思路在方法的注释中
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * Created by 林智 on 2018/5/15.
 */
public class No10 {
    /**
     * 非递归版
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        // 注意这里的初始值, 不应该是 n-1 或 n-2
        int preOne = 1;
        int preTwo = 0;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }

    /**
     * 递归版
     * @param n
     * @return
     */
    public static int Fibonacci2(int n) {
        if (n < 2) {
            return n;
        }
        return Fibonacci2(n - 1) + Fibonacci2(n - 2);

    }

    /**
     * 拓展:
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target < 3) {
            return target;
        }
        int preOne = 2;
        int preTwo = 1;
        int result = 0;
        for (int i = 3; i <= target; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;

    }

    /**
     * 关于本题，前提是n个台阶会有一次n阶的跳法。分析如下:

     f(1) = 1

     f(2) = f(2-1) + f(2-2)         //f(2-2) 表示2阶一次跳2阶的次数。

     f(3) = f(3-1) + f(3-2) + f(3-3)

     ...

     f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-(n-1)) + f(n-n)



     说明：

     1）这里的f(n) 代表的是n个台阶有一次1,2,...n阶的 跳法数。

     2）n = 1时，只有1种跳法，f(1) = 1

     3) n = 2时，会有两个跳得方式，一次1阶或者2阶，这回归到了问题（1） ，f(2) = f(2-1) + f(2-2)

     4) n = 3时，会有三种跳得方式，1阶、2阶、3阶，

     那么就是第一次跳出1阶后面剩下：f(3-1);第一次跳出2阶，剩下f(3-2)；第一次3阶，那么剩下f(3-3)

     因此结论是f(3) = f(3-1)+f(3-2)+f(3-3)

     5) n = n时，会有n中跳的方式，1阶、2阶...n阶，得出结论：

     f(n) = f(n-1)+f(n-2)+...+f(n-(n-1)) + f(n-n) => f(0) + f(1) + f(2) + f(3) + ... + f(n-1)



     6) 由以上已经是一种结论，但是为了简单，我们可以继续简化：

     f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)

     f(n) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2) + f(n-1) = f(n-1) + f(n-1)

     可以得出：

     f(n) = 2*f(n-1)



     7) 得出最终结论,在n阶台阶，一次有1、2、...n阶的跳的方式时，总得跳法为：

     | 1       ,(n=0 )

     f(n) =     | 1       ,(n=1 )

     | 2*f(n-1),(n>=2)
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        // 递归版
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }

        // 非递归版
      /*  if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            int preOne = 1;
            int res = 0;
            for (int i = 2; i <= target; i++) {
                res = preOne * 2;
                preOne = res;
            }
            return res;

            // 又或者直接给出公式解答 即 2^(target-1)
            return  1 << --target;

        }*/

    }

    public static void main(String[] args) {
        for (int i = 0; i < 30; i++){
            if (Fibonacci2(i) != Fibonacci(i)){
                System.out.println("failed");
            }
        }
    }
}
