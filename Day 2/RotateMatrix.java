class Solution {
    public void rotate(int[][] matrix) {
        // Brute Force 
        // TC: O(N*N)
        // SC: O(N*N)
        int n = matrix.length;
        int[][] ans = new int[n][n];

        // Populate the ans matrix with rotated values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][n-i-1] = matrix[i][j];
            }
        }

        // Copy the rotated values back to the original matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }
}


class Solution {
    public void rotate(int[][] matrix) {
        // Optimal Approach 
        // TC: O(N*N) + O(N*N)
        // SC: O(1)

        int n = matrix.length;
        // Observation : First Col of original Matrix = First Row of Rotated Matrix

        // 1. Transpose (i, j) <-> (j, i)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Observation : In rotated matrix rows are reversed 

        // 2. Reverse the Rows (i, j) <-> (j, i)
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
