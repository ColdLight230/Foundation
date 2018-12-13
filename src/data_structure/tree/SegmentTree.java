package data_structure.tree;

public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        // 用于存放原始数据
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        // 构造线段树, data是一颗完全二叉树，并不是满二叉树。最坏的情况需要4N的空间才能装满
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = left + (right - left) / 2;
        buildSegmentTree(leftTreeIndex, left, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, right);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Illegal index");
        }
        return data[index];
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // 返回区间[queryL, queryR]的值
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL > data.length || queryR < 0 || queryR > data.length || queryL > queryR) {
            throw new IllegalArgumentException("Illegal arguments");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree.query(2,3));
    }
}
