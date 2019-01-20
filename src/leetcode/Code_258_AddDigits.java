package leetcode;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * Example:
 * <p>
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 * Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * --------------------------------------------------------------------------
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * <p>
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 */
public class Code_258_AddDigits {

    // 循环版本
//    public int addDigits(int num) {
//        int res = 0;
//        while (num > 0) {
//            res += num % 10;
//            if (num / 10 == 0) {
//                if (res / 10 > 0) {
//                    num = res;
//                    res = 0;
//                } else {
//                    return res;
//                }
//            } else {
//                num = num / 10;
//            }
//        }
//        return num;
//    }

    // 递归版本
//    public int addDigits(int num) {
//        if (num / 10 < 0) {
//            return num;
//        }
//        int res = 0;
//        while (num > 0) {
//            res += num % 10;
//            num = num / 10;
//        }
//        return addDigits(res);
//    }

    // 非递归、非循环版本
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }

    public static void main(String[] args) {
        System.out.println("res: " + new Code_258_AddDigits().addDigits(123));
    }
}
