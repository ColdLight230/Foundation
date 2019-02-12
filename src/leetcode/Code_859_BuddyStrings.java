package leetcode;

import java.util.ArrayList;

/**
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 * <p>
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 * <p>
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 * <p>
 * Input: A = "", B = "aa"
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 * ----------------------------------------------------------------------------------------
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 示例 2：
 * <p>
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 示例 3:
 * <p>
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 示例 4：
 * <p>
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 * <p>
 * 输入： A = "", B = "aa"
 * 输出： false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 */
public class Code_859_BuddyStrings {

    // 执行用时: 5 ms, 在Buddy Strings的Java提交中击败了53.96% 的用户
    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            for (int i = 0; i < A.length(); i++) {
                for (int j = i + 1; j < A.length(); j++) {
                    if (A.charAt(i) == A.charAt(j)) {
                        return true;
                    }
                }
            }
        }
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                pos.add(i);
            }
        }
        return pos.size() == 2 && A.charAt(pos.get(0)) == B.charAt(pos.get(1)) && B.charAt(pos.get(0)) == A.charAt(pos.get(1));
    }

    public static void main(String[] args) {
//        System.out.println(new Code_859_BuddyStrings().buddyStrings("ab", "ba"));
//        System.out.println(new Code_859_BuddyStrings().buddyStrings("ab", "ab"));
//        System.out.println(new Code_859_BuddyStrings().buddyStrings("aa", "aa"));
//        System.out.println(new Code_859_BuddyStrings().buddyStrings("aaaaaaabc", "aaaaaaacb"));
//        System.out.println(new Code_859_BuddyStrings().buddyStrings("", "aa"));
        System.out.println(new Code_859_BuddyStrings().buddyStrings("abcaa", "abcbb"));
    }
}