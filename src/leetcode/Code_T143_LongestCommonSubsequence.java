package leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *  
 *
 * If there is no common subsequence, return 0.
 * -----------------------------------------------------------------------------
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：首先采用递归穷尽一个字符串的所有子串的可能  消耗时间太多，复杂度太高
 *
 * 动态规划：
 *
 */
public class Code_T143_LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        List<String> strings1 = rec_expand(text1);
        List<String> strings2 = rec_expand(text2);
        Collections.sort(strings1, (o1, o2) -> o2.length() - o1.length());
        for (int i = 0; i < strings1.size(); i++) {
            if (strings2.contains(strings1.get(i))) {
                return strings1.get(i).length();
            }
        }
        return 0;
    }

    private List<String> rec_expand(String str) {
        List<String> array = new ArrayList<>();
        if (str.length() == 1) {
            array.add(str.substring(0, 1));
            array.add("");
            return array;
        }
        String prefix = str.charAt(0) + "";
        for (String s : rec_expand(str.substring(1, str.length()))) {
            array.add(prefix + s);
            array.add(s);
        }
        return array;
    }

    /**
     * 执行用时 : 15 ms , 在所有 Java 提交中击败了 19.91% 的用户
     * 内存消耗 : 42.6 MB , 在所有 Java 提交中击败了 5.11% 的用户
     */
    private int dp_expand(String text1, String text2) {
        int[][] array = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    array[i][j] = array[i - 1][j - 1] + 1;
                } else {
                    array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
                }
            }
        }
        return array[text1.length()][text2.length()];
    }

    /**
     * 执行用时 : 7 ms , 在所有 Java 提交中击败了 96.19% 的用户
     * 内存消耗 : 37.1 MB , 在所有 Java 提交中击败了 5.11% 的用户
     */
    private int dp_expand_opt(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) return 0;
        char[] colText, rowText;
        colText = text2.toCharArray();
        rowText = text1.toCharArray();
        int[] dp = new int[colText.length + 1];
        for (int i = 1; i <= rowText.length; i++) {
            int tmp = 0;
            for (int j = 1; j <= colText.length; j++) {
                int prev = tmp;
                tmp = dp[j];
                if (rowText[i - 1] == colText[j - 1]) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[colText.length];
    }

    /**
     * 执行用时 : 10 ms , 在所有 Java 提交中击败了 77.51% 的用户
     * 内存消耗 : 37.3 MB , 在所有 Java 提交中击败了 5.11% 的用户
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        int len1 = text1.length(), len2 = text2.length();
        if (len1 == 0 || len2 == 0) return 0;
        char[] colText, rowText;
        if (len1 > len2) {
            colText = text2.toCharArray();
            rowText = text1.toCharArray();
        } else {
            colText = text1.toCharArray();
            rowText = text2.toCharArray();
        }
        int[] dp = new int[colText.length + 1];
        for (int i = 1; i <= rowText.length; i++) {
            int tmp = 0;
            for (int j = 1; j <= colText.length; j++) {
                int prev = tmp;
                tmp = dp[j];
                if (rowText[i - 1] == colText[j - 1]) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[colText.length];
    }

    public static void main(String[] args) {
        //        List<String> strings = new Code_T143_LongestCommonSubsequence().dp_expand("abcde");
        //        Collections.sort(strings, (o1, o2) -> o2.length() - o1.length());
        //        System.out.println(strings);
        System.out.println(new Code_T143_LongestCommonSubsequence().dp_expand("abcde", "ace"));
        System.out.println(new Code_T143_LongestCommonSubsequence().dp_expand("abc", "abc"));
        System.out.println(new Code_T143_LongestCommonSubsequence().dp_expand("abc", "def"));
        System.out.println(new Code_T143_LongestCommonSubsequence().dp_expand("abcde", "def"));
    }
}
