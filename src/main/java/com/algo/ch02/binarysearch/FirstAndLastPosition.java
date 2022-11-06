package com.algo.ch02.binarysearch;

/*
   Question.4
   Given an array of integers `nums` sorted in ascending order, find the starting
   and ending position of a given target value.

   If target is not found, return [-1, -1]

   You must write an algorithm with O(log n) runtime complexity.

Example:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
*/

import java.util.Arrays;

public class FirstAndLastPosition {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 7, 7, 8, 8, 10};
        int target = 7;
        int[] result = searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }

    static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};

        // check for first occurence
        ans[0] = search(nums, target, true);

        if(ans[0] != -1) {
            ans[1] = search(nums, target, false);
        }
        return ans;
    }

    // find the index value of the target
    static int search(int[] nums, int target, boolean findStartIndex) {

        int result = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                // potential ans found
                result = mid;
                if(findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return result;
    }
}
