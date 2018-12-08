package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class Code_004_MedianOfTwoSortedArrays {

    // 104 ms, 在Median of Two Sorted Arrays的Java提交中击败了11.41% 的用户
    double findMedianSortedArrays(int[] nums1, int[] nums2) {

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Comparator.reverseOrder());
        if (nums1 != null && nums2 == null) {
            return 0;
        }
        if (nums1.length == 1 && nums2.length == 0) {
            return nums1[0];
        }
        if (nums1.length == 0 && nums2.length == 1) {
            return nums2[0];
        }
        if (nums1 != null) {
            for (int i = 0; i < nums1.length; i++) {
                if (!maxQueue.isEmpty() && nums1[i] > maxQueue.peek()) {
                    maxQueue.offer(nums1[i]);
                } else {
                    minQueue.offer(nums1[i]);
                }
                if (maxQueue.size() - minQueue.size() >= 2) {
                    minQueue.offer(maxQueue.poll());
                } else if (minQueue.size() - maxQueue.size() >= 2) {
                    maxQueue.offer(minQueue.poll());
                }
            }
        }
        if (nums2 != null) {
            for (int i = 0; i < nums2.length; i++) {
                if (!maxQueue.isEmpty() && nums2[i] > maxQueue.peek()) {
                    maxQueue.offer(nums2[i]);
                } else {
                    minQueue.offer(nums2[i]);
                }
                if (maxQueue.size() - minQueue.size() >= 2) {
                    minQueue.offer(maxQueue.poll());
                } else if (minQueue.size() - maxQueue.size() >= 2) {
                    maxQueue.offer(minQueue.poll());
                }
            }
        }
        return maxQueue.size() > minQueue.size() ?
                maxQueue.poll() : minQueue.size() > maxQueue.size() ?
                minQueue.poll() : (maxQueue.poll() + minQueue.poll()) / 2d;
    }

    public static void main(String[] args) {
        Code_004_MedianOfTwoSortedArrays median = new Code_004_MedianOfTwoSortedArrays();
//        int[] nums1 = new int[]{1, 3};
//        int[] nums2 = new int[]{2};
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{2, 3};
        System.out.println(median.findMedianSortedArrays(nums1, nums2));
    }
}
