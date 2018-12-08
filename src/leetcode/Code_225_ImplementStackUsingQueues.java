package leetcode;

/**
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 * <p>
 * MyStack stack = new MyStack();
 * <p>
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */

import java.util.LinkedList;

/**
 *
 */
public class Code_225_ImplementStackUsingQueues {
    private LinkedList<Integer> data;
    private LinkedList<Integer> helper;

    public Code_225_ImplementStackUsingQueues() {
        data = new LinkedList();
        helper = new LinkedList();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        data.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (empty()) {
            throw new IllegalArgumentException("stack is empty");
        }
        while (data.size() > 1) {
            helper.offer(data.poll());
        }
        Integer poll = data.poll();
        LinkedList<Integer> temp = helper;
        helper = data;
        data = temp;
        return poll;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (empty()) {
            throw new IllegalArgumentException("stack is empty");
        }
        while (data.size() > 1) {
            helper.offer(data.poll());
        }
        Integer poll = data.poll();
        helper.offer(poll);
        LinkedList<Integer> temp = helper;
        helper = data;
        data = temp;
        return poll;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return data.isEmpty();
    }

    public static void main(String[] args) {
        Code_225_ImplementStackUsingQueues stack = new Code_225_ImplementStackUsingQueues();
        System.out.println(stack.empty());
        for (int i = 0; i < 8; i++) {
            stack.push(i);
            if (i % 3 == 0) {
                stack.pop();
            }
        }
        System.out.println("---" + stack.top());
        stack.pop();
        System.out.println("---" + stack.top());
    }
}
