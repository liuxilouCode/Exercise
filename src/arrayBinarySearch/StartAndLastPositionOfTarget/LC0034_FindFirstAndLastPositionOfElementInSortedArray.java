package arrayBinarySearch.StartAndLastPositionOfTarget;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class LC0034_FindFirstAndLastPositionOfElementInSortedArray {
    /**
     * 我们已经拆分了这道题的两个部分，find first和find last，最终只要合并起来就好
     */
    public int[] searchRange(int[] nums, int target) { //2O(log N) = O(log N)
        int[] res = new int[]{-1, -1};

        if (nums == null || nums.length == 0) return res;
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);

        return res;
    }

    private int findFirst(int[] nums, int target) {//O(log N)
        if (nums == null || nums.length ==0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] == target) return 0;
        while (l + 1 < r) {
            int m = l + (r - l)/2;
            if (nums[m] < target) l = m;
            else r = m;
        }
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }

    private int findLast(int[] nums, int target) { //O(log N)
        if (nums == null || nums.length ==0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        if (nums[r] == target) return r;
        while (l + 1 < r) {
            int m = l + (r - l)/2;
            if (nums[m] <= target) l = m;
            else r = m;
        }
        if (nums[r] == target) return r;
        if (nums[l] == target) return l;
        return -1;
    }
}
