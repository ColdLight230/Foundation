package leetcode;

/**
 * Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
 * <p>
 * If there aren't two consecutive 1's, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 22
 * Output: 2
 * Explanation:
 * 22 in binary is 0b10110.
 * In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
 * The first consecutive pair of 1's have distance 2.
 * The second consecutive pair of 1's have distance 1.
 * The answer is the largest of these two distances, which is 2.
 * Example 2:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation:
 * 5 in binary is 0b101.
 * Example 3:
 * <p>
 * Input: 6
 * Output: 1
 * Explanation:
 * 6 in binary is 0b110.
 * Example 4:
 * <p>
 * Input: 8
 * Output: 0
 * Explanation:
 * 8 in binary is 0b1000.
 * There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 * ----------------------------------------------------------------------------------------
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
 * <p>
 * 如果没有两个连续的 1，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：22
 * 输出：2
 * 解释：
 * 22 的二进制是 0b10110 。
 * 在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
 * 第一对连续的 1 中，两个 1 之间的距离为 2 。
 * 第二对连续的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 * 示例 2：
 * <p>
 * 输入：5
 * 输出：2
 * 解释：
 * 5 的二进制是 0b101 。
 * 示例 3：
 * <p>
 * 输入：6
 * 输出：1
 * 解释：
 * 6 的二进制是 0b110 。
 * 示例 4：
 * <p>
 * 输入：8
 * 输出：0
 * 解释：
 * 8 的二进制是 0b1000 。
 * 在 8 的二进制表示中没有连续的 1，所以返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 */
public class Code_868_BinaryGap {

    // 执行用时: 26 ms, 在Binary Gap的Java提交中击败了20.03% 的用户
    public int binaryGap1(int N) {
        String binaryStr = Integer.toString(N, 2);
        System.out.println(binaryStr);
        int gap = 0;
        int preIndex = -1;
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                if (preIndex == -1) {
                    preIndex = i;
                } else {
                    if (gap < i - preIndex) {
                        gap = i - preIndex;
                    }
                    preIndex = i;
                }
            }
        }
        return gap;
    }

    public int binaryGap(int N) {
        int gap = 0;
        int position = 0;
        int lastPosition = -1;
        while (N != 0) {
            position++;
            if ((N & 1) == 1) {
                if (lastPosition != -1) {
                    gap = Math.max(gap, position - lastPosition);
                }
                lastPosition = position;
            }
            N >>= 1;
        }
        return gap;
    }

    public static void main(String[] args) {
        System.out.println(new Code_868_BinaryGap().binaryGap(15));
        System.out.println(new Code_868_BinaryGap().binaryGap(22));
    }
}
