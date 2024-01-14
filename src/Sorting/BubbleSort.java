package Sorting;

public class BubbleSort {
    private void bubbleSort(int[] arr) { //O(n^2) SC:O(1) stable
        int n = arr.length;
        int cnt = 1;
        while (cnt > 0) {
            cnt = 0;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    cnt++;
                }
            }
        }
    }
}
