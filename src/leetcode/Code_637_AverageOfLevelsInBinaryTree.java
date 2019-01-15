package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * Note:
 * The range of node's value is in the range of 32-bit signed integer.
 */
public class Code_637_AverageOfLevelsInBinaryTree {

    // 执行用时: 14 ms, 在Average of Levels in Binary Tree的Java提交中击败了22.04% 的用户
//    public static List<Double> averageOfLevels(TreeNode root) {
//        List<Double> results = new ArrayList<>();
//        if (root == null) {
//            results.add(0d);
//            return results;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<TreeNode> queue1 = new LinkedList<>();
//        List<Integer> temp = new ArrayList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode cur = queue.remove();
//            temp.add(cur.val);
//            if (cur.left != null) {
//                queue1.add(cur.left);
//            }
//            if (cur.right != null) {
//                queue1.add(cur.right);
//            }
//            if (queue.isEmpty()) {
//                Queue<TreeNode> tempQueue = queue;
//                queue = queue1;
//                queue1 = tempQueue;
//                results.add(average(temp));
//                temp.clear();
//            }
//        }
//        return results;
//
//    }

    //    执行用时: 11 ms, 在Average of Levels in Binary Tree的Java提交中击败了54.79% 的用户
    public static List<Double> averageOfLevels(TreeNode root) {
        // 判空
        List<Double> results = new ArrayList<>();
        if (root == null) {
            results.add(0d);
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.remove();
                sum += cur.val;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            results.add(sum / n);
        }
        return results;

    }

    private static double average(List<Integer> arr) {
        long res = 0;
        for (int i : arr) {
            res += i;
        }
        return res * 1.0d / arr.size();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(15);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);

//        [2147483647,2147483647,2147483647]
//        [2147483647.0,-1.0]
//        TreeNode root = new TreeNode(2147483647);
//        root.left = new TreeNode(2147483647);
//        root.right = new TreeNode(2147483647);

        List<Double> doubles = averageOfLevels(root);
        for (Double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
