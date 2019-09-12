package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code_119_PascalsTriangleII {

    /**
     * 执行用时 : 4 ms , 在所有 Java 提交中击败了 31.36% 的用户
     * 内存消耗 : 34.6 MB , 在所有 Java 提交中击败了 21.84% 的用户
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            cur = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // 第一个和最后一个为1
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new Code_119_PascalsTriangleII().getRow(3));
    }
}
