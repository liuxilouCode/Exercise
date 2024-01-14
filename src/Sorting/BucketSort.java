package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void bucketSort(float[] arr, int n) {
        if (n <= 0)
            return;

        // Create bucket array
        @SuppressWarnings("unchecked")
        ArrayList<Float>[] bucket = new ArrayList[n];

        // Associate a list with each bucket
        for (int i = 0; i < n; i++) {
            bucket[i] = new ArrayList<Float>();
        }

        // Distribute the elements into buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) arr[i] * n;
            bucket[bucketIndex].add(arr[i]);
        }

        // Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(bucket[i]);
        }

        // Gather elements from each bucket
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float val : bucket[i]) {
                arr[index++] = val;
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        float[] arr = { (float)0.897, (float)0.565,
                (float)0.656, (float)0.1234,
                (float)0.665, (float)0.3434 };

        int n = arr.length;
        bucketSort(arr, n);

        System.out.println("Sorted array is ");
        for (float el : arr) {
            System.out.print(el + " ");
        }
    }
}
