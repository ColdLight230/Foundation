package zuo.demo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Code_07_IsBSTAndCBT {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // Binary Search Tree 二分搜索树
    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean res = true;
        Node pre = null;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                // 先将根节点的左子树的所有节点压栈
                stack.push(head);
                head = head.left;
            } else {
                // 如果到没有左节点，弹出这个节点
                head = stack.pop();
                if (pre != null && pre.value >= head.value){
                    return false;
                }
                pre = head;
                // 看这个节点有没有右节点，再从右节点开始，将所有左子树压栈，没有右节点就继续往上走
                head = head.right;
            }
        }

        return res;
//        boolean res = true;
//        Node pre = null;
//        Node cur1 = head;
//        Node cur2 = null;
//        while (cur1 != null) {
//            cur2 = cur1.left;
//            if (cur2 != null) {
//                while (cur2.right != null && cur2.right != cur1) {
//                    cur2 = cur2.right;
//                }
//                if (cur2.right == null) {
//                    cur2.right = cur1;
//                    cur1 = cur1.left;
//                    continue;
//                } else {
//                    cur2.right = null;
//                }
//            }
//            if (pre != null && pre.value > cur1.value) {
//                res = false;
//            }
//            pre = cur1;
//            cur1 = cur1.right;
//        }
//        return res;
    }

    // Complete Binary tree 完全二叉树  完全二叉树从根结点到倒数第二层满足完美二叉树，最后一层可以不完全填充，其叶子结点都靠左对齐。
    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            } else {
                leaf = true;
            }
        }
        return true;
    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }
}
