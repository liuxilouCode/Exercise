package Sorting;

public class CountingSort {
    void sort(int arr[]) {
        int n = arr.length;

        // The output character array that will have sorted arr
        int output[] = new int[n];

        // Create a count array to store count of individual characters and initialize count array as 0
        //range要足够小，我们本例就是在说，这些数据的range在0到255之间
        int count[] = new int[256];
        for (int i = 0; i < 256; ++i) {
            count[i] = 0;
        }

        // Store count of each character
        for (int i = 0; i < n; ++i) {
            ++count[arr[i]];
        }

        // Change count[i] so that count[i] now contains actual position of this character in output array
        for (int i = 1; i <= 255; ++i) {
            count[i] += count[i - 1];
        }

        // Build the output character array
        for (int i = 0; i < n; ++i) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now contains sorted characters
        for (int i = 0; i < n; ++i) {
            arr[i] = output[i];
        }
    }

    // Driver method
    public static void main(String args[]) {
        CountingSort countingSort = new CountingSort();
        int arr[] = {4, 2, 2, 8, 3, 3, 1};

        countingSort.sort(arr);

        System.out.print("Sorted array is ");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
    }
}
