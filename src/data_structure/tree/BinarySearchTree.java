package data_structure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 自己实现一颗二分搜索树
 * 二分搜索树指的是每个节点的左子树上的节点都比该节点小，右子树上的节点都比该节点大
 * 一般不存在重复元素，元素具有可比较性
 */
public class BinarySearchTree<E extends Comparable<E>> {

    class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    // 根节点
    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // region add
    // 插入一个元素
    public void add(E e) {
        root = add(root, e);
    }

    // 采用递归方法，往树里插入元素
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) > 0) { // 比当前节点大
            node.right = add(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }
        return node;
    }
    // endregion

    // region search
    //  查找一个元素
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 也是通过递归算法来看是否存在元素
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return true;
        }
    }
    // endregion

    // region traverse
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 非递归的前序遍历
    public void preOrderNR() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node current = stack.pop();
            System.out.println(current.e);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 非递归的中序遍历
    public void inOrderNR() {
        inOrderNR(root);
    }

    public void inOrderNR(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.empty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.e);
                head = head.right;
            }
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    private void postOrderNR() {
        postOrderNR(root);
    }

    private void postOrderNR(Node head) {
        if (head != null) {
            // 用于遍历的时候调整顺序
            Stack<Node> s1 = new Stack<Node>();
            // 用于存储节点，调整打印顺序
            Stack<Node> s2 = new Stack<Node>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                // 这里本来前序是打印，这里压到另一个栈去
                s2.push(head);
                // 以下压栈的顺序跟前序相反
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.print(s2.pop().e + " ");
            }
        }
    }

    // 层序遍历 使用队列 完美解决
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
    // endregion

    // min max
    // 寻找二分搜索树的最小元素
    public E minimum() {
        if (size == 0) {
            throw new RuntimeException("BinarySearchTree is empty");
        }
        return minimum(root).e;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum() {
        if (size == 0) {
            throw new RuntimeException("BinarySearchTree is empty");
        }
        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    // region remove
    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin() {
        E minimum = minimum();
        root = removeMin(root);
        return minimum;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;

        }
    }
    // endregion

    // for test
    public static void main(String[] args) {
        BinarySearchTree<Integer> searchTree = new BinarySearchTree();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            searchTree.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

//        System.out.println("======");
//        searchTree.preOrder();
//        System.out.println();
//        System.out.println();
//        searchTree.preOrderNR();
//        System.out.println("======");

//        System.out.println("======");
//        searchTree.inOrder();
//        System.out.println();
//        System.out.println();
//        searchTree.inOrderNR();
//        System.out.println("======");

//        System.out.println("======");
//        searchTree.postOrder();
//        System.out.println();
//        System.out.println();
//        searchTree.postOrderNR();
//        System.out.println("======");
//        searchTree.levelOrder();

        searchTree.remove(3);
        searchTree.inOrder();
    }
}
