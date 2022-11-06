package com.algo.ch02.binarysearch;

/*
* Floor = Given a number N and an array, Floor is the greatest element in
* array smaller of equal to N.
* Example:
*     array = [2,3,5,9,14,16,18]
*     floor(arr, target=14) = 9
*     floor(arr, target=15) = 14
*     floor(arr, target=4) = 3
*
*/

public class Floor {
    public static void main(String[] args){
        int[] arr = {2,3,5,9,14,16,17,18};
        int target = 5;
        int index = floor(arr, target);

        if (index == -1) {
            System.out.println("Floor number not found");
        } else {
            System.out.println(arr[index]);
        }

    }

    // return the index of n where n >= target
    static int floor(int[] arr, int target) {

        // return -1 if target is smaller than the smallest number in array
        if(target < arr[0]) return -1;

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
        return end;
    }
}
