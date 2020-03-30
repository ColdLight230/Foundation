package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * -----------------------------------------------------------------------------
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Code_040_CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> array = new ArrayList<>();
        return array;
    }

    private boolean rec_combination(int[] candidates, int target, int index) {
        if (target == 0) {
            return true;
        } else if (index == candidates.length - 1) {
            return candidates[index] == target;
        } else if (candidates[index] > target) {
            return rec_combination(candidates, target, index +1);
        } else {
            boolean A = rec_combination(candidates, target - candidates[index], index + 1);
            boolean B = rec_combination(candidates, target, index + 1);
            return A || B;
        }
    }

    public static void main(String[] args) {
        int[] intArray = new int[]{10, 1, 2, 7, 6, 1, 5};
        System.out.println(new Code_040_CombinationSumII().rec_combination(intArray, 18, 0));
        System.out.println(new Code_040_CombinationSumII().rec_combination(intArray, 19, 0));
        System.out.println(new Code_040_CombinationSumII().rec_combination(intArray, 20, 0));
        System.out.println(new Code_040_CombinationSumII().rec_combination(intArray, 25, 0));
        System.out.println(new Code_040_CombinationSumII().rec_combination(intArray, 50, 0));
    }
}
