package leetcode;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * ----------------------------------------------------------------------------------------
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Code_033_SearchInRotatedSortedArray {

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗 : 38.1 MB , 在所有 Java 提交中击败了 20.72% 的用户
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;

            if (nums[start] <= nums[mid]) {
                // 前半部分有序
                if (nums[mid] > target && nums[start] <= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                //后半部分有序
                if (nums[mid] < target && nums[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new Code_033_SearchInRotatedSortedArray().search(new int[]{1, 2, 3, 4, 5, 6}, 5));
//        System.out.println(new Code_033_SearchInRotatedSortedArray().search(new int[]{6, 1, 2, 3, 4, 5}, 5));
//        System.out.println(new Code_033_SearchInRotatedSortedArray().search(new int[]{4,  6, 1, 2, 3}, 5));
//        System.out.println(new Code_033_SearchInRotatedSortedArray().search(new int[]{5, 6, 1, 2, 3, 4}, 5));
        System.out.println(new Code_033_SearchInRotatedSortedArray().search(new int[]{3,1}, 1));
    }
}
