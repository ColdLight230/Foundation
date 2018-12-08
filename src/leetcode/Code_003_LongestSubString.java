package leetcode;

import java.util.HashMap;

/**
 * Longest Substring Without Repeating Characters
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Code_003_LongestSubString {
    static class Helper {
        public int preIndex = 0;
        public int nextIndex = 0;
        public int curIndex = 0;

        public Helper() {

        }
    }

    //    public static int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        if (s.length() == 1) {
//            return 1;
//        }
//        char[] chars = s.toCharArray();
//        HashMap<Character, Integer> map = new HashMap<>();
//        Helper[] hasRepeat = new Helper[s.length()];
//        for (int i = 0; i < chars.length; i++) {
//            hasRepeat[i] = new Helper();
//            hasRepeat[i].curIndex = i;
//            hasRepeat[i].preIndex = i;
//            hasRepeat[i].nextIndex = chars.length - 1;
//            if (map.containsKey(chars[i])) {
//                hasRepeat[i].preIndex = map.get(chars[i]);
//                hasRepeat[map.get(chars[i])].nextIndex = i;
//            }
//            map.put(chars[i], i);
//        }
//        int maxOffset = 0;
//        HashSet set = new HashSet();
//        for (Helper helper : hasRepeat) {
//            int curOffset;
//            if (helper.curIndex != helper.preIndex && chars.length - 1 != helper.nextIndex) {
//                curOffset = (helper.nextIndex - helper.curIndex) + (helper.curIndex - helper.preIndex) - 1;
//            } else {
//                curOffset = (helper.nextIndex - helper.curIndex) + (helper.curIndex - helper.preIndex);
//            }
//            if (curOffset > maxOffset) {
//                for (int i = helper.preIndex; i <= helper.nextIndex; i++) {
//                    set.add(chars[i]);
//                }
//                if (set.size() != curOffset) {
//                    curOffset = 0;
//                }
//                set.clear();
//            }
//            maxOffset = curOffset > maxOffset ? curOffset : maxOffset;
//        }
//        return maxOffset == 0 ? s.length() : maxOffset;
//    }

    // hashmap 解法
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] chars = s.toCharArray();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                // 这个 j 是精妙的一笔，永远是指向每个不同子序列的第一个位置
                // 存在相同的时候，就把 j 往后挪一步
                j = Math.max(j, map.get(chars[i]) + 1);
            }
            map.put(chars[i], i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        // input bbbbb -> b -> 1
        // input pwwkew -> wke -> 3
        // input abcabcbb -> abc -> 3
        // input abcdaefgha -> bcdaefgh ->8
        String s = "bbbbb";
//        String s = "pwwkew";
//        String s = "abcabcbb";
//        String s = "abcdaefgha";
//        String s = "a";
//        String s = "aab";
//        String s = "asljlj";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
