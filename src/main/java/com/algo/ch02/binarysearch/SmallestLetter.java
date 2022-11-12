package com.algo.ch02.binarysearch;

/*
   Given a characters array `letters` that is sorted in non-decreasing order and
   a character `target`, return the smallest character in the array that is larger
   than `target`.

    Example:
    Input:
    letters = ['c', 'f', 'j'], target = 'a'
    Output:
    'c'
*/
public class SmallestLetter {
    public static void main(String[] args) {
        char[] letters = {'c', 'd', 'f', 'j', 'm', 'r'};
        char target = 'k';
        char c = nextGreatestLetter(letters, target);
        System.out.println(c);
    }

    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while(start <= end) {
            // find the mid element
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}
