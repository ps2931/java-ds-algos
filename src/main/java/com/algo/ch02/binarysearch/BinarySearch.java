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
        int[] haystack = {1, 5, -9, -12, 8, 11, -13};
        int target = -12;
        // int index = binarySearch(haystack, target);
        int index = recBinarySearch(haystack, 0, haystack.length - 1, target);

        if (index == -1) {
            System.out.println(target + " is not in the array");
        } else {
            System.out.println(target + " is at index " + index);
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

    static int recBinarySearch(int arr[], int start, int end, int target) {
        if (end >= start) {
            // finding mid such that it will not cause integer overflow
            int mid = start + (end - start) / 2;

            // If the element is present at the middle itself
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                // If element is smaller than mid, then
                // it can only be present in left subarray
                return recBinarySearch(arr, start, mid - 1, target);
            } else {
                // Else the element can only be present in right subarray
                return recBinarySearch(arr, mid + 1, end, target);
            }
        }

        // We reach here when element is not present in array
        return -1;
    }
}
