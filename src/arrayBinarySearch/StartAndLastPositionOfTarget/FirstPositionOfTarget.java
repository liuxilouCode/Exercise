package arrayBinarySearch.StartAndLastPositionOfTarget;

/**
 * In a sorted ascending int array, find the index of the target number where it first shows up.
 * Return -1 if target does not exist.
 */
public class FirstPositionOfTarget {
    /**
     * 这道题就要透过现象看本质，看似是在找target，其实是在找分界线，找第一个target与它前一个数字的分界线，确定
     * 第一个target的index，返回该index
     * 但这道题还要考虑一个问题，就是 或许arr[0] = target 需要做pre-processing，而在做post-processing
     * 的时候，要注意必须先看左再看右 （注意在binary search当中先看左右本来是无关紧要的事情）
     */
    private int firstPositionofTarget(int[] arr, int target) {//O(log N)
        if (arr == null) return -1;
        int n = arr.length;
        if (n == 0) return -1;

        int l = 0;
        int r = n - 1;
        if (arr[l] == target) return l;

        while (l + 1 < r) {
            int m = l + (r - l)/2;
            if (arr[m] < target) l = m;//注意if条件，找first，如果第一次找到target = arr m就更新l，可能就略过第一个target了
            else r = m;
        }
        if (arr[l] == target) return l;
        if (arr[r] == target) return r;
        return -1;
    }
}
