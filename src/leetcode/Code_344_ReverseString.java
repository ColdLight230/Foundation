package leetcode;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * You may assume all the characters consist of printable ascii characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * <p>
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * -----------------------------------------------------------------------------
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 */
public class Code_344_ReverseString {

    // 执行用时: 31 ms, 在Reverse String的Java提交中击败了9.89% 的用户
    public void reverseString1(char[] s) {
        char temp;
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    // 执行用时: 16 ms, 在Reverse String的Java提交中击败了15.19% 的用户
    public void reverseString2(char[] s) {
        char temp;
        for (int i = 0; i < s.length / 2; i++) {
            int j = s.length - 1 - i;
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            s[i] = (char) (s[i] ^ s[j]);
            s[j] = (char) (s[i] ^ s[j]);
            s[i] = (char) (s[i] ^ s[j]);
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        char[] test = new char[]{'h', 'e', 'l', 'l', 'o'};
//        char[] test = new char[]{'H', 'a', 'n', 'n', 'a','h'};
//        char[] test = new char[]{'H'};
//        char[] test = new char[]{};
        new Code_344_ReverseString().reverseString(test);
        System.out.println(test);
    }
}
