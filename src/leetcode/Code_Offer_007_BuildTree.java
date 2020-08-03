package leetcode;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code_Offer_007_BuildTree {

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了82.80%的用户
     * 内存消耗：40.3 MB, 在所有 Java 提交中击败了32.36%的用户
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        // 用map存储中序遍历数组的值和下标
        HashMap<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeCore(map, preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeCore(HashMap<Integer, Integer> map, int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(preOrder[preStart]);
        if (preStart == preEnd) return node;
        int nodeIndex = map.get(preOrder[preStart]);
        int leftNodes = nodeIndex - inStart;
        int rightNodes = inEnd - nodeIndex;
        node.left = buildTreeCore(map, preOrder, preStart + 1, preStart + leftNodes, inOrder, inStart, nodeIndex - 1);
        node.right = buildTreeCore(map, preOrder, preEnd - rightNodes + 1, preEnd, inOrder, nodeIndex + 1, inEnd);
        return node;
    }


    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        System.out.println(new Code_Offer_007_BuildTree().buildTree(preOrder, inOrder));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
