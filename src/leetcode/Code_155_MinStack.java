package leetcode;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * <p>
 * <p>
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


import java.util.Stack;

/**
 * 思路：要获取当前栈的最小值。用两个栈来做，一个存储值，一个存储对应的最小值
 */
public class Code_155_MinStack {
    /**
     * : 124 ms, 在Min Stack的Java提交中击败了26.00% 的用户
     */
    private Stack<Integer> valueStack;
    private Stack<Integer> minStack;

    public Code_155_MinStack() {
        valueStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek() >= x ? x : minStack.peek());
        }
        valueStack.push(x);
    }

    public void pop() {
        valueStack.pop();
        minStack.pop();
    }

    public int top() {
        return valueStack.empty() ? 0 : valueStack.peek();
    }

    public int getMin() {
        return minStack.empty() ? 0 : minStack.peek();
    }

    public static void main(String[] args) {
        Code_155_MinStack obj = new Code_155_MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        obj.pop();
        int param_3 = obj.top();
        System.out.println(param_3 + "");
        int param_4 = obj.getMin();
        System.out.println(param_4 + "");
    }

}


