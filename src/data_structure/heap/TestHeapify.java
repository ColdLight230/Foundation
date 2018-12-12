package data_structure.heap;

import java.util.Random;

public class TestHeapify {

    private static double testHeap(Integer[] data, boolean isHeapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> heap;
        if (isHeapify){
            heap = new MaxHeap<>(data);
        }else {
            heap = new MaxHeap<>();
            for (Integer datum : data) {
                heap.add(datum);
            }
        }
        int[] arr = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            arr[i] = heap.extractMax();
        }
        for (int i = 1; i < data.length; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new RuntimeException("Error");
            }
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000d;
    }

    public static void main(String[] args) {
        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i = 0 ; i < n ; i ++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");
    }
}
