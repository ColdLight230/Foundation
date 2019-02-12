package leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * ----------------------------------------------------------------------------------------
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Code_070_ClimbingStairs {

    // 执行用时: 4 ms, 在Climbing Stairs的Java提交中击败了36.57% 的用户
    public int climbStairs(int n) {
        if (n == 1 || n == 0 || n == 2) {
            return n;
        }
        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;
        for (int i = 2; i < n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n - 1];
    }

    public static void main(String[] args) {

        System.out.println(new Code_070_ClimbingStairs().climbStairs(1));
        System.out.println(new Code_070_ClimbingStairs().climbStairs(2));
        System.out.println(new Code_070_ClimbingStairs().climbStairs(3));
        System.out.println(new Code_070_ClimbingStairs().climbStairs(4));
        System.out.println(new Code_070_ClimbingStairs().climbStairs(5));
        System.out.println(new Code_070_ClimbingStairs().climbStairs(6));
    }
}
