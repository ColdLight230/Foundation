package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * -----------------------------------------------------------------------------
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class Code_219_ContainsDuplicateII {

    // 执行用时: 420 ms, 在Contains Duplicate II的Java提交中击败了18.89% 的用户 (暴力破解)
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if (Math.abs(j - i) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 执行用时: 19 ms, 在Contains Duplicate II的Java提交中击败了76.30% 的用户
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 把超过限制偏移的移除掉
            if (i > k) set.remove(nums[i - k - 1]);
            // 在规定范围内存在相同的数，则说明可以满足条件
            if (!set.add(nums[i])) return true;
        }
        return false;
    }


    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 1, 2, 3};
//        int k = 2;
//        int[] arr = new int[]{99, 99};
//        int k = 2;
//        int[] arr = new int[]{99,99};
//        int k = 1;
        int[] arr = new int[]{1, 2, 3, 1};
        int k = 3;
        System.out.println(new Code_219_ContainsDuplicateII().containsNearbyDuplicate(arr, k));
    }
}
