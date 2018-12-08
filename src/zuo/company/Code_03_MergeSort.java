package zuo.company;

public class Code_03_MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1); // 等价 (l + r) / 2
        mergeSort(arr, l, mid); // 递归左边
        mergeSort(arr, mid + 1, r); // 递归右边
        merge(arr, l, mid, r); // 比较排序
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        // 创建一个从 l 到 r 数组
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        // 分别遍历两个数组，按大小顺序塞入help中
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 右边遍历完了，直接把左边加到数组后面
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        // 左边遍历完了，直接把右边加到数组后面
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        // 将help放回到原数组中
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
    }
}
