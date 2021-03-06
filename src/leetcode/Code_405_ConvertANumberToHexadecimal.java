package leetcode;

/**
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * <p>
 * Note:
 * <p>
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 * <p>
 * Input:
 * 26
 * <p>
 * Output:
 * "1a"
 * Example 2:
 * <p>
 * Input:
 * -1
 * <p>
 * Output:
 * "ffffffff"
 * -----------------------------------------------------------------------------
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * <p>
 * 注意:
 * <p>
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 示例 1：
 * <p>
 * 输入:
 * 26
 * <p>
 * 输出:
 * "1a"
 * 示例 2：
 * <p>
 * 输入:
 * -1
 * <p>
 * 输出:
 * "ffffffff"
 */
public class Code_405_ConvertANumberToHexadecimal {

    // 执行用时: 8 ms, 在Convert a Number to Hexadecimal的Java提交中击败了41.18% 的用户
    public String toHex1(int num) {
        if (num == 0) {
            return "0";
        }
        int i = 8;
        String s = "";
        int n;
        while (i > 0) {
            if (num == 0) {
                break;
            }
            if (num < 0) {
                int tmp = num;
                tmp = (tmp << 1) >>> 1;
                n = tmp % 16;
            } else {
                n = num % 16;
            }
            num = num >>> 4;
            if (n <= 9) {
                s = n + s;
            } else {
                n = 'a' + n - 10;
                s = (char) n + s;
            }
            i--;
        }
        return s;
    }

    char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    // 执行用时: 6 ms
    public String toHex(int num) {
        if (num == 0)
            return "0";
        String res = "";
        while (num != 0) {
            res = map[num & 15] + res;
            num >>>= 4;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Code_405_ConvertANumberToHexadecimal().toHex(-1));
        System.out.println(new Code_405_ConvertANumberToHexadecimal().toHex1(-1));
    }
}
