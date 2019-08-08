package leetcode;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * -----------------------------------------------------------------------------
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class Code_028_ImplementStrStr {

    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.19% 的用户
     * 内存消耗 : 36 MB , 在所有 Java 提交中击败了 84.01% 的用户
     */
    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && !needle.isEmpty()) return -1;
        if (haystack.length() < needle.length()) return -1;
        int len = needle.length();
        int end = len;
        while (end <= haystack.length()) {
            if (haystack.substring(end - len, end).equals(needle)) {
                return end - len;
            }
            if (end == haystack.length()) return -1;
            end++;
        }
        return end - len;
    }

    public static void main(String[] args) {
        System.out.println(new Code_028_ImplementStrStr().strStr("hello", "ll"));
        System.out.println(new Code_028_ImplementStrStr().strStr("aaaaa", "bba"));
        System.out.println(new Code_028_ImplementStrStr().strStr("aaaaa", ""));
        System.out.println(new Code_028_ImplementStrStr().strStr("", "a"));
        System.out.println(new Code_028_ImplementStrStr().strStr("aaa", "aaaa"));
    }
}
