package leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * <p>
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 * <p>
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * -----------------------------------------------------------------------------
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class Code_217_ContainsDuplicate {

    // Compile time limit exceeded, please try again.
//    public boolean containsDuplicate(int[] nums) {
//        if (nums.length == 0 || nums.length == 1) {
//            return false;
//        }
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (set.contains(nums[i])) {
//                return true;
//            }
//            set.add(nums[i]);
//        }
//        return false;
//    }

    // 执行用时: 7 ms, 在Contains Duplicate的Java提交中击败了86.18% 的用户
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1};
//        int[] arr = new int[]{1,2,3,4};
//        int[] arr = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(new Code_217_ContainsDuplicate().containsDuplicate(arr));
    }
}
