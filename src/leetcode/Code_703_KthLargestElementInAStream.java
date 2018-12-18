package leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * <p>
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * <p>
 * 示例:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 */

/**
 * 143 ms, 在Kth Largest Element in a Stream的Java提交中击败了49.14% 的用户
 * <p>
 * 102 ms, 在Kth Largest Element in a Stream的Java提交中击败了84.76% 的用户
 */
public class Code_703_KthLargestElementInAStream {
    private PriorityQueue<Integer> queue;
    private int k;

    public Code_703_KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k, Comparator.naturalOrder());
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
    }

    public int add(int val) {
        queue.offer(val);
        if (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }

    // 142 ms, 在Kth Largest Element in a Stream的Java提交中击败了51.05% 的用户
//    public Code_703_KthLargestElementInAStream(int k, int[] nums) {
//        this.k = k;
//        queue = new PriorityQueue<>(k, Comparator.naturalOrder());
//        for (int num : nums) {
//            add(num);
//        }
//    }
//
//    public int add(int val) {
//        if (queue.size() < k) {
//            queue.offer(val);
//        } else if (queue.peek() < val) {
//            queue.poll();
//            queue.offer(val);
//        }
//        return queue.peek();
//    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};
        Code_703_KthLargestElementInAStream kthLargest = new Code_703_KthLargestElementInAStream(3, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));   // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }
}
