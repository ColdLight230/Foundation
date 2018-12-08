package zuo.company;

/**
 * 荷兰国旗问题
 */
public class Code_04_NetherlandsFlag {
    public static int[] partition(int[] arr, int left, int right, int num) {
        int less = left - 1;
        int more = right + 1;
        int cur = left;
        while (less < more) {
            if (arr[cur] < num) {
                SwapUtils.swap(arr, ++cur, less++);
            } else if (arr[cur] > num) {
                SwapUtils.swap(arr, cur, right--);
            } else {
                cur++;
            }
        }
        // 返回的是数组内等于num的左右两个下标
        return new int[]{less + 1, more - 1};
    }
}
