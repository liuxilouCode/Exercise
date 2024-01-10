package Sorting;

public class QuickSort {
    private int partition(int arr[], int low, int high) {
        int pivot = arr[high]; //use the rightest number as pivot
        int i = (low - 1); // i at position -1
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j] 这里要注意这个比较本身和arr[i]与arr[j]无关，纯粹是为了把小的元素的位置调到左边
                //例如 {10, 9, 8, 7, 1, 5} 5是pivot，经过前四轮对比，此时i仍然等于-1，第五轮1<5, i++ = 0, arr[0] 与 arr[4]
                //对调位置所以结果变成{1, 9 ,8, 7, 10, 5}
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //整个循环结束后 结果仍然是 {1, 9, 8, 7, 10, 5}
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1]; //此时i+1是因为已经知道了第i位必然是最后一个被挑出来发现小与5的数字，那5正确的位置必然在此数之后
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1; //5的位置即i+1
    }

    /* The main function that implements QuickSort
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is now at right place */
            int pi = partition(arr, low, high);
            // Recursively sort elements before partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    // A utility function to print array of size n
    private static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        printArray(arr);
    }
}
