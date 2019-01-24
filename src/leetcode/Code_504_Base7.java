package leetcode;

/**
 * Given an integer, return its base 7 string representation.
 * <p>
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 * ---------------------------------------------------
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 100
 * 输出: "202"
 * 示例 2:
 * <p>
 * 输入: -7
 * 输出: "-10"
 * 注意: 输入范围是 [-1e7, 1e7] 。
 */
public class Code_504_Base7 {

    // 循环算法
//    public String convertToBase7(int num) {
//        if (num == 0) return "0";
//        boolean isNegative = num < 0;
//        StringBuilder sb = new StringBuilder();
//        num = Math.abs(num);
//        while (num != 0) {
//            sb.append(num % 7);
//            num /= 7;
//        }
//        sb.append(isNegative ? "-" : "");
//        return sb.reverse().toString();
//    }

    // 递归算法
//    public String convertToBase7(int num) {
//        if (num < 0)
//            return '-' + convertToBase7(-num);
//        if (num < 7)
//            return num + "";
//        return convertToBase7(num / 7) + num % 7;
//    }

    public String convertToBase7(int num) {
        return Integer.toString(num,7);
    }



    public static void main(String[] args) {
        System.out.println(new Code_504_Base7().convertToBase7(100));
        System.out.println(new Code_504_Base7().convertToBase7(-7));
        System.out.println(new Code_504_Base7().convertToBase7(0));
        System.out.println(new Code_504_Base7().convertToBase7(56));
        System.out.println(new Code_504_Base7().convertToBase7(49));
        System.out.println(new Code_504_Base7().convertToBase7(343));
        System.out.println(new Code_504_Base7().convertToBase7(349));
        System.out.println(new Code_504_Base7().convertToBase7(350));
    }
}
