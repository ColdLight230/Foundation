package leetcode;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 * <p>
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 * <p>
 * Input: 218
 * Output: false
 * -----------------------------------------------------------------------------
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 * <p>
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 * <p>
 * 输入: 218
 * 输出: false
 */
public class Code_231_PowerOfTwo {

    // 执行用时: 5 ms, 在Power of Two的Java提交中击败了71.05% 的用户
    public boolean isPowerOfTwo1(int n) {
        if (n <= 0) return false;
        if (n <= 2) return true;
        while (n / 2 >= 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    // 执行用时: 1 ms, 在Power of Two的Java提交中击败了100.00% 的用户
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code_231_PowerOfTwo().isPowerOfTwo(0));
    }
}
