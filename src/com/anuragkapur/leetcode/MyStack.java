package com.anuragkapur.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Implements a stack using a queue.
 * Problem #225, https://leetcode.com/problems/implement-stack-using-queues/
 * 
 * @author anuragkapur
 */
class MyStack {

    private Deque<Integer> deque;

    public MyStack() {
        deque = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        Deque<Integer> temp = new LinkedList<>();
        temp.addLast(x);
        while(!deque.isEmpty()) {
            temp.addLast(deque.removeFirst());
        }
        deque = temp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!deque.isEmpty())
            deque.removeFirst();
    }

    // Get the top element.
    public int top() {
        if(!deque.isEmpty())
            return deque.getFirst();
        return -1;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return deque.isEmpty();
    }
}
