package leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 * -----------------------------------------------------------------------------
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class Code_035_SearchInsertPosition {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 87.03% 的用户
     * 内存消耗 : 38.5 MB , 在所有 Java 提交中击败了 63.22% 的用户
     */
    public int searchInsert1(int[] nums, int target) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] >= target) {
                return index;
            }
            index++;
        }
        return index;
    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                end = middle - 1;
            } else if (nums[middle] < target) {
                start = middle + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(new Code_035_SearchInsertPosition().searchInsert(nums, 7));
    }
}
