package arrayBinarySearch;

/**
 * Given a sorted int array and a target int number, return the index of the target if existed or -1 if not found.
 */
public class BinarySearch {
    private int binarySearch(int[] arr, int target){ //O(log N) 最差就是走一半 O(1)
        //左右越过
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        if (arr[l] == target) return l;
        if (arr[r] == target) return r;
        while (l <= r) {
            int m = l + (r - l)/2;

            if (arr[m] == target) {
                return m;
            } else if (arr[m] < target) {
                l = m + 1;//更新必须m+1， m-1，否则最后可能会l=m死循环 试想只有一个元素 l = r = 0 m = 0
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    private int binarySearchAdjacent(int[] arr, int target){
        //左右相邻，一般更适合找近似值，尤其是当target不存在时
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        if (arr[l] == target) return l;
        if (arr[r] == target) return r;
        while (l + 1 < r) {
            int m = l + (r - l)/2;

            if (arr[m] == target) {
                return m;
            } else if (arr[m] < target) {
                l = m; //找分界线就必须要l = m 这也是左右越过和左右相邻的最大区别
            } else {
                r = m; //虽然l=m-1在这个例子里也是对的，但是这样这个代码就只能找值而不能找分界线
            }
        }
        // post-processing because loop condition l + 1 < r 会产生没检查最后的l和r对应的值
        if (arr[l] == target) return l;
        if (arr[r] == target) return r;
        return -1;
    }
}
