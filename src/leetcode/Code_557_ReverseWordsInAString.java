package leetcode;

import java.util.Stack;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * <p>
 * -----------------------------------------------------------------------------
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class Code_557_ReverseWordsInAString {

    // 执行用时: 60 ms, 在Reverse Words in a String III的Java提交中击败了23.08% 的用户
    public String reverseWords1(String s) {
        if (s == null || s.length() == 1) return s;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                while (!stack.isEmpty()) {
                    stringBuilder.append(stack.pop());
                }
                stringBuilder.append(' ');
            } else {
                stack.push(chars[i]);
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    // 执行用时: 16 ms, 在Reverse Words in a String III的Java提交中击败了65.69% 的用户
    public String reverseWords(String s) {
        if (s == null || s.length() == 1) return s;
        String[] split = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            split[i] = new StringBuilder(split[i]).reverse().toString();
            stringBuilder.append(split[i]).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new Code_557_ReverseWordsInAString().reverseWords(s));
    }
}
