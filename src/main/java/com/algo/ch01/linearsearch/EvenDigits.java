package com.algo.ch01.linearsearch;

import java.lang.Math;

/*
 * Given an array `numbers` of integers, return how many of them contain an even number of digits.
 */

public class EvenDigits {

	public static void main(String[] args) {
		int[] nums = { 123, 0, 45, 5678, 1, 23 };

		int count = findEvenDigitNumbers(nums);
		System.out.println(count);

	}

	static int findEvenDigitNumbers(int[] nums) {

		int count = 0;
		for (int n : nums) {									
			int digitCount = countDigits(n);

			if (isEven(digitCount))
				count++;
		}
		return count;
	}

	// faster as compare to while loop
	static int countDigits(int n) {

		if (n == 0) {
			return 1;
		} else if (n < 0) {
			n = n * -1;
			return (int) (Math.log10(n)) + 1;
		} else {
			return (int) (Math.log10(n)) + 1;
		}

	}

	// check if number is even or not
	static boolean isEven(int n) {
		if (n == 0)
			return false;
		return Math.abs(n) % 2 == 0;
	}
}
