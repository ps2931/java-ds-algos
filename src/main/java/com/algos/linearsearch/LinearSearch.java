package com.algos.linearsearch;

import java.util.Arrays;

/*
Task:
	Given a list of numbers find the index of a number.

Complexity of linear search:
    - Best case:  O(1)
    - Worst case: O(N), where N is the size of the input
*/

public class LinearSearch {

	public static void run() {
		int[] numbers = { 23, 45, 1, 2, 7, 19, -3, 16, -11, 28 };
		int target1 = -11;

		// search for target1 in an array
		int targetIndex = linearSearchFindIndex(numbers, target1);
		System.out.println(targetIndex);

		// search for target2 only in the given index range (3-8)
		int target2 = 28;
		System.out.println(linearSearchInRange(numbers, target2, 2, 7));

		// find smallest element in an array
		int min = min(numbers);
		System.out.println(min);

		// search a char in a string
		String s = "jklmonpxyzabcdefghi";
		char c = 'x';
		boolean isCharFound = searchCharInString(s, c);
		System.out.println(isCharFound);

		// 2D array
		int[][] matrix = new int[][] { 
			{ 23, 4, 11 }, 
			{ 18, 12, 3, 9 }, 
			{ 78, 89, 14, 42 }, 
			{ 18, 1 }, 
		};

		// search an element in a 2D array
		int target3 = 14;
		int[] row_and_column_index = searchInMatrix(matrix, target3);		
		System.out.println(Arrays.toString(row_and_column_index));
	
		// find max element in 2D array
		int maxElement = maxInMatrix(matrix);
		System.out.println(maxElement);
		
		// find min element in 2D array
		int minElement = minInMatrix(matrix);
		System.out.println(minElement);
	}

	// search in the array: return index if item found otherwise return -1
	static int linearSearchFindIndex(int[] arr, int target) {

		// return -1 if array has no element
		if (arr.length == 0)
			return -1;

		// iterate through the array
		for (int i = 0; i < arr.length; i++) {
			// check the element at every index if it is equal to target
			if (arr[i] == target) {
				return i;

			}
		}

		// reaching here means target has not been found in the array
		// hence return -1
		return -1;
	}

	// search in the array but only in a range of index
	// return index if item found otherwise return -1
	static int linearSearchInRange(int[] arr, int target, int start, int end) {

		// return -1 if array has no element
		if (arr.length == 0)
			return -1;

		// iterate through the array
		for (int i = start; i <= end; i++) {
			// check the element at every index if it is equal to target
			if (arr[i] == target) {
				return i;

			}
		}

		// reaching here means target has not been found in the array
		// hence return -1
		return -1;
	}

	static int min(int[] arr) {
		
		int min = Integer.MAX_VALUE;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];
		}

		return min;
	}
	
	static int max(int[] arr) {
		
		int max = Integer.MIN_VALUE;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}

		return max;
	}

	// find an element in a 2D array
	static int[] searchInMatrix(int[][] arr, int target) {

		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == target)
					return new int[] { i, j };
			}
		return new int[] {-1, -1};
	}
	
	static int maxInMatrix(int[][] arr) {
		
		int max = Integer.MIN_VALUE;
		
		for (int[] a: arr) {
			int tempMax = max(a); // find max in a[]
			if (tempMax > max) max = tempMax;
		}
		return max;
	}

	static int minInMatrix(int[][] arr) {
		
		int min = Integer.MAX_VALUE;
		
		for (int[] a: arr) {
			int tempMin = min(a); // find max in a[]
			if (tempMin < min) min = tempMin;
		}
		return min;
	}
	
	// search a char in a string. return true/false
	static boolean searchCharInString(String str, char target) {
		
		if (str.length() == 0)
			return false;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == target) {
				return true;
			}
		}

		// char has not been found
		return false;
	}
}
