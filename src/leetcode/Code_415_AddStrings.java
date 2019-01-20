package leetcode;

import java.math.BigInteger;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * --------------------------------------------------------------------------
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class Code_415_AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';
            stringBuilder.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) stringBuilder.append(carry);
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code_415_AddStrings().addStrings("1233213213123214", "12354365758124"));
        System.out.println(new Code_415_AddStrings().forTest("1233213213123214", "12354365758124"));
    }

    private String forTest(String num1, String num2) {
        BigInteger value1 = new BigInteger(num1);
        BigInteger value2 = new BigInteger(num2);
        return String.valueOf(value1.add(value2));
    }
}
