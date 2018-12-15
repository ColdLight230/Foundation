package data_structure.tree;

import java.util.ArrayList;

public class BST<K extends Comparable<K>, V> {


    class Node {
        K key;
        V value;
        Node left;
        Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    // 根节点
    private Node root;
    private int size;

    public BST() {
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
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    // 采用递归方法，往树里插入元素
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) > 0) { // 比当前节点大
            node.right = add(node.right, key, value);
        } else if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        }
        return node;
    }
    // endregion

    // region search
    //  查找一个元素
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) > 0) {
            return getNode(node.right, key);
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return node;
        }
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }
    // endregion

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist");
        }
        node.value = newValue;
    }

    // min max
    // 寻找二分搜索树的最小元素
    public Node minimum() {
        if (size == 0) {
            throw new RuntimeException("BinarySearchTree is empty");
        }
        return minimum(root);
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public Node maximum() {
        if (size == 0) {
            throw new RuntimeException("BinarySearchTree is empty");
        }
        return maximum(root);
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
    public Node removeMin() {
        Node minimum = minimum();
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
    public Node removeMax() {
        Node ret = maximum();
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

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
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
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BST<String, Integer> map = new BST<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }


}
