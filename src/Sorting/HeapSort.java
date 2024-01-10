package Sorting;

public class HeapSort {
    public void sort(int arr[]) {
        int n = arr.length;

        // Build a heap from the array
        for (int i = n / 2 - 1; i >= 0; i--) //in a complete binary tree presented as an array, the last
            //non leaf node is indexed at n/2 - 1, where n is the length of the array (# of nodes)
            heapify(arr, n, i);

        // Extract elements from the heap one by one
        for (int i = n - 1; i >= 0; i--) { // n iterations of heapify, so total TC is O(nlogn)
            // Move current root to end, which may result a violation of max heap, so we need to heapify
            // the reduced size heap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0); //对提取完root元素的max heap，当我们要
            // 重新heapify剩余heap时，起始节点是0而不再是n/2 - 1,因为只有这一个元素可能出错
            //之所以是reduced heap （size为i） 是因为i后面的array都已经sort好了 （我们是max heap，
            //从最大值开始填值，所以是倒着走的）
        }
    }

    // To heapify a subtree rooted with node i which is an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i) { //O(log n)
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child exists and is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child exists and is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // A utility function to print array of size n
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
