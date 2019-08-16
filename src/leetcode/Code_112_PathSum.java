package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * -----------------------------------------------------------------------------
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class Code_112_PathSum {

    /**
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 44.28% 的用户
     * 内存消耗 : 38.3 MB , 在所有 Java 提交中击败了 43.38% 的用户
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;
        List<Integer> result = new ArrayList<>();
        paths(root, result,0);
        return result.contains(sum);
    }

    private void paths(TreeNode node, List<Integer> totals, int sum) {
        if (node.left == null && node.right == null) {
            totals.add(sum + node.val);
        }
        if (node.left != null) {
            paths(node.left, totals, sum + node.val);
        }
        if (node.right != null) {
            paths(node.right, totals, sum + node.val);
        }
    }

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.77% 的用户
     * 内存消耗 : 38.2 MB , 在所有 Java 提交中击败了 43.70% 的用户
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return sum == 0;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.right.left = new TreeNode(13);
        node.right.right = new TreeNode(4);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right.right.right = new TreeNode(1);

        System.out.println(new Code_112_PathSum().hasPathSum(node, 22));
    }
}
