package data_structure.queue;

import java.util.Random;

public class Comparion {

    public static double testQueue(Queue<Integer> queue, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000d;
    }

    public static void main(String[] args) {
        int opCount = 100000;
        double time1 = testQueue(new ArrayQueue<>(), opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");
        double time2 = testQueue(new LoopQueue<>(), opCount);
        System.out.println("ArrayQueue, time: " + time2 + " s");
    }
}
