package com.algo.ch02.binarysearch;

/*
Given an array nums of positive integers and an integer m,
you can split the array into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.

Example: nums = [7,2,5,10,8], m = 2
Output: 18

There are four ways to split the nums into two subarrays. 
The best way is to split it into [7,2,5] and [10,8], where
the largest sum among the two subarray is only 18.
 
Solution: https://www.youtube.com/watch?v=bcAwHkL7A3A
*/

import java.util.Arrays;

public class LargestSum {

  public static void main(String[] args) {
    int[] arr = {7,2,5,10,8};
    int m = 2;
    System.out.println(splitInArray(arr, m));
  }

  static int splitInArray(int[] nums, int m) {
    int start = Arrays.stream(nums).max().getAsInt();
    int end = Arrays.stream(nums).sum() + 1;

    while (start < end) {
      int mid = (start + end) / 2;

      if (numGroups(nums, mid) > m) start = mid + 1;
      else end = mid;
    }

    return start;
  }

  // find number of subarrays with max sum as mid
  static int numGroups(int[] nums, int maxSumInGroup) {
    int groupCount = 1;
    int sumInGroup = 0;

    for (final int num : nums)
      if (sumInGroup + num <= maxSumInGroup) {
        sumInGroup += num;
      } else {
        ++groupCount;
        sumInGroup = num;
      }
      return groupCount;
    }
  }
