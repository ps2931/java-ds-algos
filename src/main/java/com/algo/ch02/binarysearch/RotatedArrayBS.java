package com.algo.ch02.binarysearch;

/*
An array nums has been rotated at an unknown pivot index k s.t
nums[k], nums[k+1], ...,nums[n-1], nums[0], nums[1], ...nums[k-1]
For example, [0,1,2,4,5,6,7] rotated at pivot index 3 will become
[4,5,6,7,0,1,2].

Given an array nums after the rotation and an integer target, return
the index of target if it is in nums or -1 if it is not in nums.

Input: [4,5,6,7,0,1,2], target = 0
Output: 4

Reference:
https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
*/

/*
7 is the element after which elements starts decreasing.
That means 7 is the pivot element.

Or we can say, 3,4,5,6,7 is ascending, and 0,1,2 is also ascending.
Only 7,0 is in descending order.
*/

public class RotatedArrayBS {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 1;
        System.out.println(search(arr, target));

        /*
        If array has duplicates, the above technique will not work.
        In search() method, replace findPivot() with findPivotWithDuplicates()
        Rest of the code will be same.

        int[] arr2 = {4,5,6,6,7,0,0,1,2,3};
        int target = 1; // answer will be 7
        */

    }

    static int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return binarySearch(nums, target, 0 , nums.length - 1);
        }

        if (nums[pivot] == target) {
            return pivot;
        }

        // if pivot is found, you have found 2 asc sorted arrays
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        } else {
            return binarySearch(nums, target, pivot + 1, nums.length - 1);
        }
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            // find the middle element
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return -1;
    }

    // this will not work if array has duplicate values
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    static int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid-1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
