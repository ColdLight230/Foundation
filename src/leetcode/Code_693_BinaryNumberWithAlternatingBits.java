package leetcode;

/**
 * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
 * <p>
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation:
 * The binary representation of 5 is: 101
 * Example 2:
 * Input: 7
 * Output: False
 * Explanation:
 * The binary representation of 7 is: 111.
 * Example 3:
 * Input: 11
 * Output: False
 * Explanation:
 * The binary representation of 11 is: 1011.
 * Example 4:
 * Input: 10
 * Output: True
 * Explanation:
 * The binary representation of 10 is: 1010.
 * ----------------------------------------------------------------------------------------
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释:
 * 5的二进制数是: 101
 * 示例 2:
 * <p>
 * 输入: 7
 * 输出: False
 * 解释:
 * 7的二进制数是: 111
 * 示例 3:
 * <p>
 * 输入: 11
 * 输出: False
 * 解释:
 * 11的二进制数是: 1011
 * 示例 4:
 * <p>
 * 输入: 10
 * 输出: True
 * 解释:
 * 10的二进制数是: 1010
 */
public class Code_693_BinaryNumberWithAlternatingBits {

    // 执行用时: 14 ms, 在Binary Number with Alternating Bits的Java提交中击败了69.36% 的用户
    public boolean hasAlternatingBits(int n) {
        int lastNum = -1;
        boolean isAlternating = true;
        while (n != 0) {
            if (lastNum != -1 && (n & 1) == lastNum) {
                isAlternating = false;
            }
            lastNum = n & 1;
            n >>= 1;
        }
        return isAlternating;
    }

//    public boolean hasAlternatingBits(int n) {
//         /*
//        n =         1 0 1 0 1 0 1 0
//        n >> 1      0 1 0 1 0 1 0 1
//        n ^ n>>1    1 1 1 1 1 1 1 1
//        n           1 1 1 1 1 1 1 1
//        n + 1     1 0 0 0 0 0 0 0 0
//        n & (n+1)   0 0 0 0 0 0 0 0
//        */
//
//        n = n ^ (n>>1);
//        return (n & n+1) == 0;
//    }

    public static void main(String[] args) {
        System.out.println(new Code_693_BinaryNumberWithAlternatingBits().hasAlternatingBits(10));
    }
}
