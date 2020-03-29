package leetcode;

import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * --------------------------------------------------------------------------
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class Code_139_WordBreak {

    public static void main(String[] args) {
        //        System.out.println(new Code_139_WordBreak().wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
        System.out.println(new Code_139_WordBreak().wordBreak("aaaaaaaaaaa", new ArrayList<>(Arrays.asList("a", "b"))));
        //        System.out.println(new Code_139_WordBreak().wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen"))));
        //        System.out.println(new Code_139_WordBreak().wordBreak("catsanddog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
    }

    // 暴力破解法 超出时间限制 如aaaaaaaaa 的情况
    public boolean wordBreak1(String s, List<String> wordDict) {
        return wordBreak1(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreak1(String s, Set<String> wordDict, int start) {
        // 最后一个单词能匹配上，start最后一次进来是刚好遍历完字符串
        if (s.length() == start) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            // 遍历字符串，去掉一个前缀并且子项也满足这个情况
            if (wordDict.contains(s.substring(start, end)) && wordBreak1(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    // 记忆法回溯 执行用时 : 8 ms , 在所有 Java 提交中击败了 61.17% 的用户
    public boolean wordBreak2(String s, List<String> wordDict) {
        return wordBreak2(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreak2(String s, Set<String> wordDict, int start, Boolean[] memo) {
        // 最后一个单词能匹配上，start最后一次进来是刚好遍历完字符串
        if (s.length() == start) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            // 遍历字符串，去掉一个前缀并且子项也满足这个情况
            if (wordDict.contains(s.substring(start, end)) && wordBreak2(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    // 执行用时 : 2 ms , 在所有 Java 提交中击败了 96.98% 的用户
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (String str : wordDict) {
            max = Math.max(str.length(), max);
            set.add(str);
        }
        // 记录map，记录重复的计算的结果
        HashMap<Integer, Boolean> map = new HashMap<>(s.length());
        return getResult(s, 0, set, max, map);
    }

    /**
     *
     * @param s
     * @param start  表示索引开始位置
     * @param set    字段中字符串的集合
     * @param max    每次遍历s时不可以超出max长度，否则肯定为false
     * @param map    记忆表
     * @return
     */
    private boolean getResult(String s, int start, HashSet<String> set, int max, HashMap<Integer, Boolean> map) {
        if (start == s.length()) {
            return true;
        }
        if (map.containsKey(start)) {
            return map.get(start);
        }
        // 关键步骤： 遍历的时候加上max的长度限制，避免无限遍历至s结尾
        for (int i = start; i < start + max && i < s.length(); i++) {
            if (set.contains(s.substring(start, i + 1))) {
                if (getResult(s, i + 1, set, max, map)) {
                    map.put(start, true);
                    return true;
                }
            }
        }
        map.put(start, false);
        return false;
    }
}
