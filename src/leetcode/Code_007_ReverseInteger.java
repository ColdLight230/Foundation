package leetcode;

import java.util.Stack;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment
 * which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class Code_007_ReverseInteger {


    public static int reverse(int x) {
        boolean isNegative = x != Math.abs(x);
        x = Math.abs(x);
        Stack<Integer> stack = new Stack<>();
        while (x / 10 != 0 || x % 10 != 0) {
            stack.push(x % 10);
            x /= 10;
        }
        int level = 0;
        int res = 0;
        while (!stack.empty()) {
            int temp = (int) (stack.pop() * Math.pow(10, level));
            if (res + temp < 0) {
                return 0;
            } else {
                res += temp;
            }
            System.out.println("" + (res > Integer.MAX_VALUE));
            level++;
        }
        return isNegative ? 0 - res : res;
    }

    public static void main(String[] args) {
        System.out.println("" + Integer.MIN_VALUE);
        System.out.println("" + reverse(Integer.MIN_VALUE));
    }
}
