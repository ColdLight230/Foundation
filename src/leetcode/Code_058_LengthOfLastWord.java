package leetcode;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 * -----------------------------------------------------------------------------
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 */
public class Code_058_LengthOfLastWord {

    /**
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 38.25% 的用户
     * 内存消耗 : 35.3 MB , 在所有 Java 提交中击败了 83.15% 的用户
     */
    public int lengthOfLastWord1(String s) {
        int result = 0;
        StringBuffer reverse = new StringBuffer(s.trim()).reverse();
        while (result < reverse.length()) {
            if (reverse.charAt(result) == ' ') {
                return result;
            } else {
                result++;
            }
        }
        return result;
    }

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 93.08% 的用户
     * 内存消耗 : 35.9 MB , 在所有 Java 提交中击败了 70.80% 的用户
     */
    public int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int end = s.length() - 1;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println(new Code_058_LengthOfLastWord().lengthOfLastWord("hello world"));
        System.out.println(new Code_058_LengthOfLastWord().lengthOfLastWord(""));
        System.out.println(new Code_058_LengthOfLastWord().lengthOfLastWord("a "));
    }
}
