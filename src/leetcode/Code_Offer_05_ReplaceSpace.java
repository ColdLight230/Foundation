package leetcode;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Code_Offer_05_ReplaceSpace {

    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                stringBuilder.append('%').append('2').append('0');
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public String replaceSpace1(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }

    public static void main(String[] args) {
        System.out.println(new Code_Offer_05_ReplaceSpace().replaceSpace("We are happy."));
    }
}
