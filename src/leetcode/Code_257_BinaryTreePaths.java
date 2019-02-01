package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * Output: ["1->2->5", "1->3"]
 * <p>
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 * ----------------------------------------------------------------------------------------
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class Code_257_BinaryTreePaths {

//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> result = new ArrayList<>();
//        if (root == null) {
//            return result;
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        paths(root, result, stringBuilder);
//        return result;
//    }
//
//    private void paths(TreeNode node, List<String> result, StringBuilder stringBuilder) {
//        stringBuilder.append(node.val);
//        if (node.left == null && node.right == null) {
//            result.add(stringBuilder.toString());
//            return;
//        }
//        if (node.left != null) {
//            stringBuilder.append("->");
//            paths(node.left, result, stringBuilder);
//            stringBuilder.delete(stringBuilder.lastIndexOf(">") - 1, stringBuilder.length());
//        }
//        if (node.right != null) {
//            stringBuilder.append("->");
//            paths(node.right, result, stringBuilder);
//            stringBuilder.delete(stringBuilder.lastIndexOf(">") - 1, stringBuilder.length());
//        }
//
//    }

    // 执行用时: 17 ms, 在Binary Tree Paths的Java提交中击败了73.41% 的用户
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            paths(root, result, "");
        }
        return result;
    }

    private void paths(TreeNode node, List<String> result, String path) {
        if (node.left == null && node.right == null) {
            result.add(path + node.val);
        }
        if (node.left != null) {
            paths(node.left, result, path + node.val + "->");
        }
        if (node.right != null) {
            paths(node.right, result, path + node.val + "->");
        }

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(new Code_257_BinaryTreePaths().binaryTreePaths(root));

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
