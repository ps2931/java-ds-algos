package com.algo.ch02.binarysearch;

/*
Question: Given a sorted and rotated array arr[] of size N and a key, the task is
to find the key in the array.

Note: Find the element in O(logN) time and assume that all the elements are distinct.

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}, key = 30
Output : Not found

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}, key = 2
Output : Found at index 7

Solution Approach:
Create a recursive function to implement the binary search where the search
region is [l, h]. For each recursive call:

    - We calculate the mid value as mid = (l + h) / 2
    - Then try to figure out if l to mid is sorted, or (mid+1) to h is sorted
    - Based on that decide the next search region and keep on doing this till the element is found or l overcomes h.

*/
public class RotationCount {
    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        int n = arr.length;
        int key = 2;
        int i = search(arr, 0, n - 1, key);
        if (i != -1)
            System.out.println("Index: " + i);
        else
            System.out.println("Key not found");
    }

    static int search(int arr[], int l, int h, int key) {
        if (l > h)
            return -1;

        int mid = l + (h -l) / 2;
        if (arr[mid] == key) return mid;

        // if arr[l...mid] first subarray is sorted
        if(arr[l] <= arr[mid]) {
            if (key >= arr[l] && key <= arr[mid])
                return search(arr, l, mid - 1, key);

            return search(arr, mid + 1, h, key);
        }

        // if arr[mid... h] is sorted
        if (key >= arr[mid] && key <= arr[h])
            return search(arr, mid + 1, h, key);

        return search(arr, l, mid - 1, key);
    }

}
