package leetcode;

/**
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 * <p>
 * <p>
 * Note:
 * <p>
 * You may assume that all elements in nums are unique.
 * n will be in the range [1, 10000].
 * The value of each element in nums will be in the range [-9999, 9999].
 * ----------------------------------------------------------------------------------------
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class Code_704_BinarySearch {

    // 执行用时: 3 ms, 在Binary Search的Java提交中击败了98.92% 的用户
    public int search(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        while (low <= high) {
            if (nums[(low + high) / 2] == target) {
                return (low + high) / 2;
            } else if (nums[(low + high) / 2] < target) {
                low = (low + high) / 2 + 1;
            } else {
                high = (low + high) / 2 - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] num = new int[]{-1, 0, 3, 5, 9, 12};
        int[] num = new int[]{2, 5};
        int target = 5;
        System.out.println(new Code_704_BinarySearch().search(num, target));
    }
}
