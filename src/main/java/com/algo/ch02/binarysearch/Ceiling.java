package com.algo.ch02.binarysearch;

/*
* Ceiling = Given a number N and an array, Ceiling is the smallest element in
* array greater of equal to N.
* Example:
*     array = [2,3,5,9,14,16,18]
*     Ceiling(arr, target=14) = 14
*     Ceiling(arr, target=15) = 16
*     Ceiling(arr, target=4) = 5
*
*/

public class Ceiling {
    public static void main(String[] args){
        int[] arr = {2,3,5,9,14,16,17,18};
        int target = 15;
        int index = ceiling(arr, target);

        if (index == -1) {
            System.out.println("Ceiling number not found");
        } else {
            System.out.println(arr[index]);
        }
    }

    // return the index of n where n >= target
    static int ceiling(int[] arr, int target) {

        // return -1 if target is greater than the greatest number in array
        if(target > arr[arr.length -1]) return -1;

        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            // find the middle element
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}
