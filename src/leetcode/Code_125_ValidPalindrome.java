package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * Input: "race a car"
 * Output: false
 * -----------------------------------------------------------------------------
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class Code_125_ValidPalindrome {

    // 超出时间限制
    public boolean isPalindrome1(String s) {
        if (s == null || s.length() <= 1) return true;
        s = s.toLowerCase();
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (isNumOrChar(s.charAt(i))) {
                stack.push(s.charAt(i));
                queue.add(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll()) return false;
        }
        return true;
    }

    private boolean isNumOrChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    // 超出时间限制
    public boolean isPalindrome2(String s) {
        if (s == null || s.length() <= 1) return true;
        s = s.toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (isNumOrChar(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            if (stack.size() == 1) return true;
            if (stack.pop() != stack.remove(0)) return false;
        }
        return true;
    }

    // 超出时间限制
    public boolean isPalindrome3(String s) {
        if (s == null || s.length() <= 1) return true;
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (!isNumOrChar(chars[i])) {
                i++;
                //匹配 "   " 这样的空白字符串防止越界
                if (i == s.length()) {
                    return true;
                }
            }
            while (!isNumOrChar(chars[j])) {
                j--;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    private static final char[] charMap = new char[256];

    static {
        // 映射 '0' 到 '9'
        for (int i = 0; i < 10; i++) {
            charMap[i + '0'] = (char) (1 + i); // numeric
        }
        // 映射 'a' 到 'z' 和 映射 'A' 到 'Z'
        for (int i = 0; i < 26; i++) {
            charMap[i + 'a'] = charMap[i + 'A'] = (char) (11 + i);
        }
    }

    /**
     * 执行用时 : 6 ms , 在所有 Java 提交中击败了 96.90% 的用户
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        char[] pChars = s.toCharArray();
        int start = 0, end = pChars.length - 1;
        char cS, cE;
        while (start < end) {
            // 得到映射后的数字
            cS = charMap[pChars[start]];
            cE = charMap[pChars[end]];
            if (cS != 0 && cE != 0) {
                if (cS != cE)
                    return false;
                start++;
                end--;
            } else {
                if (cS == 0)
                    start++;
                if (cE == 0)
                    end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //        System.out.println((int) 'A');
        //        System.out.println((int) 'Z');
        //        System.out.println((int) 'a');
        //        System.out.println((int) 'z');
        //        System.out.println((int) '0');
        //        System.out.println((int) '9');
        System.out.println(new Code_125_ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Code_125_ValidPalindrome().isPalindrome("race a car"));
        System.out.println(new Code_125_ValidPalindrome().isPalindrome(""));
        System.out.println(new Code_125_ValidPalindrome().isPalindrome(null));
        System.out.println(new Code_125_ValidPalindrome().isPalindrome("1"));
    }
}
