package leetcode;

/**
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
 * <p>
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 * <p>
 * Example 1:
 * Input:
 * bits = [1, 0, 0]
 * Output: True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * Example 2:
 * Input:
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation:
 * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 * Note:
 * <p>
 * 1 <= len(bits) <= 1000.
 * bits[i] is always 0 or 1.
 * ---------------------------------------------------------
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * <p>
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 * 示例 2:
 * <p>
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 * 注意:
 * <p>
 * 1 <= len(bits) <= 1000.
 * bits[i] 总是0 或 1.
 */
public class Code_717_Characters {

    // 最后一位是0，逆序的连续1的位数是偶数
    // 执行用时: 8 ms, 在1-bit and 2-bit Characters的Java提交中击败了64.54% 的用户
    public boolean isOneBitCharacter(int[] bits) {
        int count = 0;
        for (int i = bits.length - 2; i >= 0; i--) {
            if (bits[i] == 1) {
                count++;
            } else {
                break;
            }
        }
        return count % 2 == 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 0};
        System.out.println(new Code_717_Characters().isOneBitCharacter(arr));
    }
}
