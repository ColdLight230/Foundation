package leetcode;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * <p>
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * -----------------------------------------------------------------------------
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class Code_204_CountPrimes {

    // 超出时间限制 暴力破解
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isPrimes(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrimes1(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 优化第一步 判断质数，只需要把i的范围限定住

    /**
     * Let's write down all of 12's factors:
     * <p>
     * 2 × 6 = 12
     * 3 × 4 = 12
     * 4 × 3 = 12
     * 6 × 2 = 12
     * As you can see, calculations of 4 × 3 and 6 × 2 are not necessary.
     * Therefore, we only need to consider factors up to √n because,
     * if n is divisible by some number p, then n = p × q and since p ≤ q, we could derive that p ≤ √n.
     */
    // 执行用时: 861 ms, 在Count Primes的Java提交中击败了4.23% 的用户
    private boolean isPrimes(int num) {
        if (num == 2) return true;
        if (num <= 1 || num % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 执行用时: 45 ms, 在Count Primes的Java提交中击败了33.46% 的用户
    public int countPrimes1(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrimes[i * j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(new Code_204_CountPrimes().isPrimes(4));
        System.out.println(new Code_204_CountPrimes().countPrimes1(12));
    }
}
