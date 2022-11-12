package com.algo.ch02.binarysearch;

public class OrderAgnosticBS {

   public static void main(String[] args) {
        int[] arr1 = {99, 80, 75, 22, 11, 10, 5, 2, -3};
        int target1 = 22;
        int ans1 = orderAgnosticBS(arr1, target1);
        System.out.println(ans1);

        int[] arr2 = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int target2 = 22;
        int ans2 = orderAgnosticBS(arr2, target2);
        System.out.println(ans2);
    }

    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            // find the middle element
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
