package com.jianzhiOffer;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * 定义栈的数据结构, 请在该类型中实现一个能够得到栈的最小元素的 min 函数.
 * 在该栈中, 调用 min, push 以及 pop 的时间复杂度都是 O(1)
 *
 * Created by 林智 on 2018/5/24.
 */
public class No30 {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty() || node < minStack.peek()) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty() && !minStack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return 0;
    }

    public int min() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return 0;
    }
}
