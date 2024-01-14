package Sorting;

public class SelectionSort {
    private void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = arr[i];
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    idx = j;
                }
            }
            if (idx != i) {
                arr[idx] = arr[i];
                arr[i] = min;
            }
        }
    }
}
