package test;

/**
 * 删除字符串中的空格
 */
public class DeleteBlankSpaceInString {

    public static void main(String[] args) {
        System.out.println((deleteBlankSpace(" I lo ve  y ou")));
    }

    public static String deleteBlankSpace1(String string) {
        char[] charArray = string.toCharArray();
        int i = 0;
        int j = 0;
        while (charArray[i] == ' ') {
            i++;
        }
        while (i < charArray.length) {
            if (charArray[i] == ' ') {
                i++;
                continue;
            }
            charArray[j++] = charArray[i++];
        }
        String result = new String(charArray);
        return result.substring(0, j);
    }
    public static String deleteBlankSpace(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (string.charAt(i) == ' ') {
            i++;
        }
        while (i < string.length()) {
            if (string.charAt(i) == ' ') {
                i++;
                continue;
            }
            stringBuilder.append(string.charAt(i++));
        }
        return stringBuilder.toString();
    }
}


