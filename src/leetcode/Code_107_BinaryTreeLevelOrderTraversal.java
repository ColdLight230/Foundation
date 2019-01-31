package leetcode;

import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * ----------------------------------------------------------------------------------------
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class Code_107_BinaryTreeLevelOrderTraversal {

    // 执行用时: 2 ms, 在Binary Tree Level Order Traversal II的Java提交中击败了85.16% 的用户
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null){
            return new ArrayList<>(new ArrayList<>());
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> otherQueue = new LinkedList<>();
        List<Integer> element = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            otherQueue.add(cur);
            element.add(cur.val);
            if (queue.isEmpty()) {
                List<Integer> temp = new ArrayList<>(element);
                result.add(0, temp);
                element.clear();
                while (!otherQueue.isEmpty()) {
                    TreeNode remove = otherQueue.remove();
                    if (remove.left != null) {
                        queue.add(remove.left);
                    }
                    if (remove.right != null) {
                        queue.add(remove.right);
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = new Code_107_BinaryTreeLevelOrderTraversal().levelOrderBottom(null);
        System.out.println(lists);

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



