package com.algo.ch02.binarysearch;

import java.util.Arrays;

/*
Find an element in a matrix which have sorted rows.

Approach:

for
  row -> 1 to N
  col -> N to 0

  Compare last element of each row with target.
    - If target is less than last element, then reduce the size of matrix to [row][col-1]
    - Otherwise, reduce the size of matrxi to [row++][col]
    - During the search if anytime target == matrix[row][col]; return matrix[row][col]
*/

public class RowColMatrix {
  public static void main(String[] args) {
    int[][] arr = {
                {10, 20, 30, 40},
                {15, 24, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };

    int result[] = search(arr, 37);
    System.out.println(Arrays.toString(result));
  }

  static int[] search(int[][] matrix, int target) {
    int row = 0;
    int col = matrix.length - 1;

    while (row < matrix.length && col >= 0) {
      if (matrix[row][col] == target) 
        return new int[]{row,col};

      if (matrix[row][col] > target) col--;
      else row++;

      // for debug purposes
      printMatrix(matrix, row, col);
    }
    return new int[]{-1, -1};
  }

  static void printMatrix(int[][] matrix, int row, int col) {
    for (int i = 0; i <= row; i++) {
    for (int j = 0; j <= col; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
    }
  }
}
