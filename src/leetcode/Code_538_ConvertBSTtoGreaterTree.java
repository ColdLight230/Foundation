package leetcode;


import java.util.Stack;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 * <p>
 * Example:
 * <p>
 * Input: The root of a Binary Search Tree like this:
 * 5
 * /   \
 * 2     13
 * <p>
 * Output: The root of a Greater Tree like this:
 * 18
 * /   \
 * 20     13
 * -----------------------------------------------------------------------------
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 * 例如：
 * <p>
 * 输入: 二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 */
public class Code_538_ConvertBSTtoGreaterTree {
    // region 递归写法 执行用时: 13 ms, 在Convert BST to Greater Tree的Java提交中击败了75.66% 的用户
    private int preNum;

    public TreeNode convertBST(TreeNode root) {
        postOrder(root);
        return root;
    }

    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.right);
        node.val += preNum;
        preNum = node.val;
        postOrder(node.left);
    }
    // endregion

    // 非递归写法  执行用时: 18 ms, 在Convert BST to Greater Tree的Java提交中击败了51.53% 的用户
    public TreeNode convertBST1(TreeNode root) {
        if (root == null) {
            return root;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                node = node.right;
            }
            node = stack.pop();
            node.val += preNum;
            preNum = node.val;
            node = node.left;
        }
        return root;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        System.out.println(new Code_538_ConvertBSTtoGreaterTree().convertBST(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
