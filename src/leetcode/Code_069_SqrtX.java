package leetcode;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 * -----------------------------------------------------------------------------
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code_069_SqrtX {

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 81.47%
     * 的用户
     * 内存消耗 :
     * 33.6 MB
     * , 在所有 Java 提交中击败了
     * 54.53% 的用户
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 1;
        int right = x / 2 + 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid <= x / mid && mid + 1 > x / (mid + 1)) {
                return mid;
            }
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(new Code_069_SqrtX().mySqrt(8));
        System.out.println(new Code_069_SqrtX().mySqrt(4));
        System.out.println(new Code_069_SqrtX().mySqrt(225));
    }
}
