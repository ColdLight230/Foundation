package leetcode;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 * -----------------------------------------------------------------------------
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class Code_088_MergeSortedArray {

    // 执行用时: 7 ms, 在Merge Sorted Array的Java提交中击败了12.30% 的用户
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    // 执行用时: 5 ms, 在Merge Sorted Array的Java提交中击败了68.74% 的用户
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从最大值处 倒着赋值

        // 确定最大值的位置，并获取各个数组最大值的下标
        int k = (m--) + (n--) - 1;
        while(m >= 0 && n >= 0){
            // 取两个数组中的最大值
            nums1[k--] = nums2[n] > nums1[m] ? nums2[n--] : nums1[m--];
        }
        // 遍历完了nums1 的情况
        while(n >= 0) nums1[k--] =  nums2[n--];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new Code_088_MergeSortedArray().merge(nums1, 3, nums2, 3);
        System.out.println(nums1);
        for (int i : nums1) {
            System.out.println(i + "");
        }
    }
}
