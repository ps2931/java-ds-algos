package com.algos.linearsearch;

/*
 * You are given an `m x n` matrix `accounts` where accounts[i][j] is
 * the amount of money the ith customer has in the jth bank. Return
 * the `wealth` that the richest customer has.
 *   
 *   Example:
 *   accounts = [[1,2,3],[3,2,1]]
 *   Output: 6
 *   Explanation:
 *   1st customer has wealth = 1 + 2 + 3 = 6
 *   2nd customer has wealth = 3 + 2 + 1 = 6
 *   Both customers are considered the richest with a wealth
 *   of 6 each, so return 6
 */

public class MaxWealth {
	
	public static void main(String[]args) {
		int[][] accounts =  { {1, 2, 3}, {3, 3, 3}, {4,5,6} };
		
		int maxSum = maximumWealth(accounts);
		System.out.println(maxSum);
	}
	
	public static int maximumWealth(int[][] accounts) {
		
		int maxSum = Integer.MIN_VALUE;
		
		// iterate over each row
		for (int[] account: accounts) {
			
			// take sum of each row
			int sum = 0;			
			for (int n: account) {
				sum += n;
			}
			
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}

}
