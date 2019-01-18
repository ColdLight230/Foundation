package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * --------------------------------------------------------------
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class Code_067_AddBinary {

    //    public String addBinary(String a, String b) {
//        char[] aChars = a.toCharArray();
//        char[] bChars = b.toCharArray();
//        Stack<Character> aStack = new Stack<>();
//        Stack<Character> bStack = new Stack<>();
//        for (char aChar : aChars) {
//            aStack.push(aChar);
//        }
//        for (char bChar : bChars) {
//            bStack.push(bChar);
//        }
//        int longLength = aChars.length > bChars.length ? aChars.length + 1 : bChars.length + 1;
//
//        ArrayList<Character> resChars = new ArrayList<>();
//        int carry = 0;
//        for (int i = longLength - 1; i >= 0; i--) {
//            Character aPop = 'a';
//            Character bPop = 'b';
//            if (!aStack.isEmpty() && !bStack.isEmpty()) {
//                aPop = aStack.pop();
//                bPop = bStack.pop();
//            } else if (!aStack.isEmpty()) {
//                aPop = aStack.pop();
//            } else if (!bStack.isEmpty()) {
//                bPop = bStack.pop();
//            }
//            if ('1' == aPop && '1' == bPop) {
//                if (carry == 1) {
//                    resChars.add('1');
//                } else {
//                    resChars.add('0');
//                }
//                carry = 1;
//            } else if ('1' == aPop || '1' == bPop) {
//                if (carry == 1) {
//                    carry = 1;
//                    resChars.add('0');
//                } else {
//                    carry = 0;
//                    resChars.add('1');
//                }
//            } else {
//                if (carry == 1) {
//                    resChars.add('1');
//                } else {
//                    resChars.add('0');
//                }
//                carry = 0;
//            }
//        }
//        String res = resChars.size() > 0 ? "" : "0";
//        for (int i = resChars.size() - 1; i >= 0; i--) {
//            res += resChars.get(i);
//        }
//        return res;
//    }
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum%2);
            carry = sum/2;
        }
        if (carry !=0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Code_067_AddBinary solution = new Code_067_AddBinary();
        System.out.println(solution.addBinary("100", "110010"));
    }
}
