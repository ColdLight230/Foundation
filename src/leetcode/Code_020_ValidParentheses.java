package leetcode;


import java.util.Stack;

public class Code_020_ValidParentheses {

    // 6ms  97.50%
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == ')' && (stack.empty() || stack.pop() != '(')) {
                return false;
            } else if (s.charAt(i) == ']' && (stack.empty() || stack.pop() != '[')) {
                return false;
            } else if (s.charAt(i) == '}' && (stack.empty() || stack.pop() != '{')) {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
//        String s = "{";
        String s = "()";
//        String s = "()[]{}";
//        String s = "(]";
//        String s = "([)]";
//        String s = "{[]}";
//        String s = "]";
        System.out.println(isValid(s));
    }
}
