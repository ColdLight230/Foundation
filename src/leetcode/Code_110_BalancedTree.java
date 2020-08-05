package leetcode;

public class Code_110_BalancedTree {

    // 执行用时: 2 ms, 在Balanced Binary Tree的Java提交中击败了76.65% 的用户
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int balancedFactor = getBalancedFactor(root);
        if (Math.abs(balancedFactor) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private int getBalancedFactor(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Code_110_BalancedTree().isBalanced(root));
//        System.out.println(new Code_110_BalancedTree().getHeight(root));
        // ----------------

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(3);
        root1.left.left.left = new TreeNode(4);
        root1.left.left.right = new TreeNode(4);
        System.out.println(new Code_110_BalancedTree().isBalanced(root1));
//        System.out.println(new Code_110_BalancedTree().getHeight(root1));
    }
}


