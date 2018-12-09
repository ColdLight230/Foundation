package leetcode;


import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 */
public class Code_844_BackspaceStringCompare {
    // 执行用时: 12 ms, 在Backspace String Compare的Java提交中击败了58.09% 的用户
    public static boolean backspaceCompare(String str1, String str2) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == '#') {
                if (!stack1.isEmpty())
                    stack1.pop();
            } else {
                stack1.push(str1.charAt(i));
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == '#') {
                if (!stack2.isEmpty())
                    stack2.pop();
            } else {
                stack2.push(str2.charAt(i));
            }
        }

        while (!stack1.isEmpty()) {
            if (stack2.isEmpty()) {
                return false;
            } else {
                if (stack1.pop() != stack2.pop()) {
                    return false;
                }
            }
        }
        return stack2.isEmpty();
    }

    public static void main(String[] args) {
//        System.out.println(backspaceCompare("ab#c", "ad#c"));
//        System.out.println(backspaceCompare("ab##", "d#c#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
//        System.out.println(backspaceCompare("a#c", "c"));
//        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
