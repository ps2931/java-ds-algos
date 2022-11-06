package com.algo.ch02.binarysearch;

/*
Suppose you have a sorted array of infinite numbers, how would you search an
element in the array?

Since array is sorted, the first thing clicks into mind is binary search, but
the problem here is that we don’t know size of array.

If the array is infinite, that means we don’t have proper bounds to apply binary
search. So in order to find position of key, first we find bounds and then apply
binary search algorithm.

In order to find lower and upper bounds, set low to first element and high to second
element of the array. Compare target with high index element.

 - if it is greater than high index element then copy high index in low index and double the high index.
 - if it is smaller, then apply binary search on high and low indices found.

*/
public class InfiniteArray {
  public static void main(String[] args) {
    // assume arr is an infinite array and we don't the last index
    int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};

    int target = 10;
    System.out.println(ans(arr, target));
  }

  // find the range [start, end] in which target lies
  static int ans(int[] arr, int target) {
    int start = 0;
    int end = 1;

    // condition for the target to lie in the range
    while(target > arr[end]) {
      int temp = end + 1; // calculate new start value
      end = end + (end - start + 1) * 2;
      start = temp;
      System.out.println("start=" + start + " " + "end=" + end);
    }
    return binarySearch(arr, start, end, target);
  }

  static int binarySearch(int[] arr, int start, int end, int target) {
    System.out.println("start=" + start + " " + "end=" + end);
    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (target < arr[mid]) {
        end = mid - 1;
      } else if (target > arr[mid]) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
