package com.algo.ch02.binarysearch;

/*
Given a sorted rotating array, find the rotation count in rotated sorted array.
*/

public class RotationCount {
  public static void main(String[] args) {
    int[] arr = {4,5,6,7,0,1,2};
    int rotationCount = countRotations(arr);
    System.out.println(rotationCount); // 4
  }

  static int countRotations(int[] arr) {
    int pivot = findPivot(arr);
    return pivot + 1;
  }

  // use this for non duplicates
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
}
