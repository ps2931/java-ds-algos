package com.algo.ch02.binarysearch;
/*
An array is mountain array if and only if:
 - A.length > 3
 - There exists some i with 0 < i < A.length-1 s.t:
    - A[0] < A[1] < ... A[i-1] < A[i]
    - A[i] > A[i+1] > ... > A[A.length-1]

Find peek i.e A[i]
*/

public class Mountain {
    public static void main(String[] args) {
        int[] arr = {3,5,7,9,10,11,10,6,5,4,3};
        int peek = peakIndexInMountainArray(arr);
        System.out.println(peek);
    }

    // https://leetcode.com/problems/peak-index-in-a-mountain-array/
    // https://leetcode.com/problems/find-peak-element/
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid+1]) {
                // you are in dec part of array
                // this may be the ans, but look at left
                // this is why end != mid - 1
                end = mid;
            } else {
                // you are in asc part of array
                start = mid + 1; // because we know that mid+1 element > mid element
            }
        }
        // in the end, start == end and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
        return start; // or return end as both are =
    }
}
