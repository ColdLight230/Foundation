package leetcode;


import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class Code_232_ImplementQueueUsingStacks {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public Code_232_ImplementQueueUsingStacks() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }


    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inputStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (empty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (outputStack.empty()){
            while (!inputStack.empty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (empty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (outputStack.empty()){
            while (!inputStack.empty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inputStack.empty() && outputStack.empty();
    }

    public static void main(String[] args) {
        Code_232_ImplementQueueUsingStacks queue = new Code_232_ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        queue.push(3);
        System.out.println(queue.peek());
    }
}
