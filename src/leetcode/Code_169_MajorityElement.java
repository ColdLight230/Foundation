package leetcode;

import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * -----------------------------------------------------------------------------
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class Code_169_MajorityElement {

    // 摩尔投票法
    // 因为数量超过一半，把不相同的一一对应删除，留下的肯定是最多的
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (majority == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majority = nums[i + 1];
                }
            }
        }
        return majority;
    }

    // 执行用时: 7 ms, 在Majority Element的Java提交中击败了76.35% 的用户
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
//        int[] array = new int[]{3,2,3};
        int[] array = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(new Code_169_MajorityElement().majorityElement1(array));
    }
}
