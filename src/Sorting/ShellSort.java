package Sorting;

public class ShellSort {

    private static void shellSort(int[] arr) {
        int len =  arr.length;

        for (int gap = len/2; gap > 0; gap/=2) {
            for (int i = gap; i < len; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && j-gap >= 0 && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3};
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
