package leetcode;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 */
public class Code_Offer_04_FindNumberIn2DArray {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗：45.6 MB , 在所有 Java 提交中击败了 57.93% 的用户
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //[
        //  [1,   4,  7, 11, 15],
        //  [2,   5,  8, 12, 19],
        //  [3,   6,  9, 16, 22],
        //  [10, 13, 14, 17, 24],
        //  [18, 21, 23, 26, 30]
        //]
        int[] a1 = new int[]{1, 4, 7, 11, 15};
        int[] a2 = new int[]{2, 5, 8, 12, 19};
        int[] a3 = new int[]{3, 6, 9, 16, 22};
        int[] a4 = new int[]{10, 13, 14, 17, 24};
        int[] a5 = new int[]{18, 21, 23, 26, 30};
        int[][] matrix = new int[][]{a1, a2, a3, a4, a5};
        //        int[] b1 = new int[]{-5};
        //        int[][] matrix = new int[][]{b1};


        System.out.println(new Code_Offer_04_FindNumberIn2DArray().findNumberIn2DArray(matrix, 5));
        System.out.println(new Code_Offer_04_FindNumberIn2DArray().findNumberIn2DArray(matrix, 20));
        System.out.println(new Code_Offer_04_FindNumberIn2DArray().findNumberIn2DArray(matrix, 30));
        System.out.println(new Code_Offer_04_FindNumberIn2DArray().findNumberIn2DArray(matrix, 31));
        //        System.out.println(new Code_Offer_04_FindNumberIn2DArray().findNumberIn2DArray(matrix, -5));
    }
}
