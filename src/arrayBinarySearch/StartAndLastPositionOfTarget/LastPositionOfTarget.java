package arrayBinarySearch.StartAndLastPositionOfTarget;

/**
 * similar to first position of index, this one looks for the last time the target shows up
 */
public class LastPositionOfTarget {
    private int firstPositionofTarget(int[] arr, int target) {
        if (arr == null) return -1;
        int n = arr.length;
        if (n == 0) return -1;

        int l = 0;
        int r = n - 1;
        if (arr[r] == target) return r;
        while (l + 1 < r) {
            int m = l + (r - l)/2;
            if (arr[m] <= target) l = m; //注意if条件，找last，有可能第一次找到的target不是最后一个，更新r就出错了
            else r = m;
        }
        if (arr[r] == target) return r; //post processing 的时候要先看右再看左了
        if (arr[l] == target) return l;
        return -1;
    }
}
