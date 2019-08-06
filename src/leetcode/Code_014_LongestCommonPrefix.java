package leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 * -----------------------------------------------------------------------------
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */

public class Code_014_LongestCommonPrefix {

    /**
     * 暴力破解
     * 执行用时 :5 ms, 在所有 Java 提交中击败了 26.01% 的用户
     * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了82.57% 的用户
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length <= 0 || strs[0].isEmpty()) return "";
        String prefix = String.valueOf(strs[0].charAt(0));
        while (prefix.length() <= strs[0].length()) {
            for (String str : strs) {
                if (!str.startsWith(prefix)) {
                    return prefix.substring(0, prefix.length() - 1);
                }
            }
            if (prefix.length() == strs[0].length()) return prefix;
            prefix += strs[0].substring(prefix.length(), prefix.length() + 1);
            System.out.println("prefix = " + prefix);
        }
        return prefix;
    }

    /**
     * 二分法
     * 执行用时 : 1 ms, 在所有 Java 提交中击败了 99.94% 的用户
     * 内存消耗 : 35.9 MB, 在所有 Java 提交中击败了 87.94% 的用户
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str = strs[0].substring(0, len);
        for (String s : strs) {
            if (!s.startsWith(str)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] strings = new String[]{"flower","flow","flight"};
//        String[] strings = new String[]{"dog","racecar","car"};
        String[] strings = new String[]{"dog", "", "car"};
//        String[] strings = new String[]{"a"};
        System.out.println("result : " + new Code_014_LongestCommonPrefix().longestCommonPrefix(strings));
    }
}
