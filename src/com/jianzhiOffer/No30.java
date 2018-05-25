package com.jianzhiOffer;

import java.util.Stack;

/**
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
