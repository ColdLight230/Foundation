package leetcode;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * */
public class Code_001_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(nums[i])){
                return new int[]{i, map.get(nums[i])};
            }
            map.put(diff, i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{65538,2,4};
        int[] res = twoSum(nums, 6);
        if (res != null) {
            for (int re : res) {
                System.out.print(re + " ,");
            }
        } else {
            System.out.println("null");
        }
    }
}
