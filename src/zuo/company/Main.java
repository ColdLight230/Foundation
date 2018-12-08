package zuo.company;

public class Main {

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean success = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 =Checker.generateRandomArray(maxSize,maxValue);
            int[] arr2 = Checker.copyArray(arr1);
            Checker.comparator(arr1);
            Code_03_MergeSort.mergeSort(arr2);
            if (!Checker.isEqual(arr1,arr2)){
                success = false;
                break;
            }
        }
        System.out.println(success?"Nice":"Error");
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.print("[" + arr[i] + ",");
            } else if (i == arr.length - 1) {
                System.out.print(arr[i] + "]");
            } else {
                System.out.print(String.valueOf(arr[i]) + ",");
            }
        }
    }
}
