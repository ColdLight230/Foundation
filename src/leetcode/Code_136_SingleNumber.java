package leetcode;

import java.util.HashMap;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 * -----------------------------------------------------------------------------
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Code_136_SingleNumber {

    /**
     * 利用 HashMap 保存出现的次数，Time: O(n) Space: O(n)
     */
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            count = count == null ? 1 : ++count;
            map.put(num, count);
        }
        for (Integer integer : map.keySet()) {
            Integer count = map.get(integer);
            if (count == 1) {
                return integer;
            }
        }
        return -1;
    }

    /**
     * 利用异或算法的特性，一个数异或两遍另一个数，结果还是自己 Time: O(n) Space: O(1)
     *
     * 异或运算满足以下定律：（离散数学有详解）
     * 交换律：a ^ b ^ c <=> a ^ c ^ b
     * 任何数与0异或 0 ^ n = n
     * 相同的数异或为0 n ^ n => 0
     */
    public int singleNumber2(int[] nums) {
        int result = nums[0];
        for (int num : nums) {
            result = result ^ num;
        }
        return result ^ nums[0];
    }

    /**
     * 与上面方法一样，少做了一次运算
     */
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(new Code_136_SingleNumber().singleNumber(nums));
    }
}
