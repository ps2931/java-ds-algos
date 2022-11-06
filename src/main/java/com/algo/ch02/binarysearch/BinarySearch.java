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

        System.out.println("--------------------------------");

        System.out.println("Binary Search Ascending ordered Array");
        int[] ascHaystack = {-5, -1, 3, 5, 8, 9, 12, 13};
        int index3 = orderAgnostincBinarySearch(ascHaystack, target);
        if (index3 == -1) {
            System.out.println(target + " is not in the array");
        } else {
            System.out.println(target + " is at index " + index3);
        }

        System.out.println("--------------------------------");

        System.out.println("Binary Search Descending ordered Array");
        int[] descHaystack = {13, 12, 9, 8, 5, 3, -1, -5};
        int index4 = orderAgnostincBinarySearch(descHaystack, target);
        if (index4 == -1) {
            System.out.println(target + " is not in the array");
        } else {
            System.out.println(target + " is at index " + index4);
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

    static int orderAgnostincBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // check if array is sorted in asc or desc order
        boolean isAsc;
        if (arr[start] < arr[end]) {
            isAsc = true;
        } else {
            isAsc = false;
        }

        while (end >= start) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target)  return mid;

            if(isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    start = mid + 1;
                }
            } else {
                if (target < arr[mid]) {
                    start = mid + 1;
                } else if(target > arr[mid]) {
                    end = mid -1;
                }
            }
        }
        return -1;
    }
}
