package com.algo.ch02.binarysearch;

/*
 * Binary Search:
 *
 * Procedure:
 * 1. Set L to 0 and R to n-1.
 * 2. If L > R, the search terminates as unsuccessful.
 * 3. Set m = (L+R)/2
 * 4. If A(m) < T, set L to m+1 and go to step 2.
 * 5. If A(m) > T, set R to m-1 and go to step 2.
 * 6. Now A(m) = T, the search is done; return m.
 *
 * Performance:
 *  Best case: O(1)
 *  Worst case: O(log n)
 *
 * Worst case space complexity O(1)
 */

public class BinarySearch {

    public static void main(String[] args) {
        int[] haystack = {-5, -1, 3, 5, 8, 9, 12, 13};
        int target = 5;

        System.out.println("--------------------------------");

        System.out.println("Iterative Binary Search");
        int index1 = binarySearch(haystack, target);
        if (index1 == -1) {
            System.out.println(target + " is not in the array");
        } else {
            System.out.println(target + " is at index " + index1);
        }
    }

    static int binarySearch(int[] nums, int target) {
        int end = nums.length -1 ;
        int start = 0;
        while(end >= start) {
            int mid = (start + end) >>> 1;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
