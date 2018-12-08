package zuo.demo;

public class Code_08_CompleteTreeNodeNumber {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /**
     * 递归的方法
     *  level 指的是当前节点所在的层级
     *  h 值整颗树的高度，不变化
     */
    public static int bs(Node node, int level, int h) {
        if (level == h) {
            // 总共就一层，个数肯定就是1
            return 1;
        }
        if (mostLeftLevel(node.right, level + 1) == h) {
            // 如果右子树的左边界 是 在最后一层
            // 左子树的个数 加上 头节点，1 << (h - level))
            // 递归右子树
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        } else {
            // 如果右子树的左边界 不是 在最后一层
            // 右子树的个数 加上 头节点，1 << (h - level - 1))
            // 递归左子树
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

    // 移动到左边界，获取树的高度
    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }

}
