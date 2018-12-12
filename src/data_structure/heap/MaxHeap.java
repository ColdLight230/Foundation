package data_structure.heap;

import java.util.Random;

import data_structure.array.Array;

/**
 * �Լ�����ʵ��һ�������
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] array) {
        data = new Array<>(array);
        for (int i = parent(array.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // ������ȫ�������������ʾ���У�һ����������ʾ��Ԫ�صĸ��ڵ������
    public int parent(int index) {
        if (index == 0) throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // ������ȫ�������������ʾ���У�һ����������ʾ��Ԫ�ص����ӵ�����
    public int leftChild(int index) {
        return 2 * index + 1;
    }

    // ������ȫ�������������ʾ���У�һ����������ʾ��Ԫ�ص��Һ��ӵ�����
    public int rightChild(int index) {
        return 2 * index + 2;
    }

    // ����в���Ԫ�أ��ȷ�����β�ˣ�Ȼ���������ϱȽ��ϸ�
    public void add(E e) {
        data.addLast(e);
        siftUp(size() - 1);
    }

    // �ϸ�����������һЩ�������Ѷ��ƶ�
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // �³���������СһЩ�������ѵ��ƶ�
    private void siftDown(int k) {
        while (leftChild(k) < size()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }
            if (data.get(j).compareTo(data.get(k)) <= 0) {
                break;
            }
            data.swap(j, k);
            k = j;
        }
    }


    //�鿴���Ԫ��
    public E findMax() {
        if (size() == 0) {
            throw new RuntimeException("Heap is empty");
        }
        return data.get(0);
    }

    // �����������Ԫ��
    public E extractMax() {
        E ret = findMax();
        data.swap(0, size() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    // ȡ���������Ԫ�أ������滻��Ԫ��e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    // for test
    public static void main(String[] args) {
        int n = 100000;
        MaxHeap<Integer> heap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = heap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new RuntimeException("Error");
            }
        }
        System.out.println("test MaxHeap completed");
    }
}
