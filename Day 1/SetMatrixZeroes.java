// Brute Force Approach
// TC: O((N*M) * (N + M)) + O(N*M)
// SC: O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        // Brute Force

        int n = matrix.length;
        int m = matrix[0].length;

        // Traverse the matrix to find zeros //O(N*M)
        for (int i = 0; i < n; i++) {  
            for (int j = 0; j < m; j++) {
                // If a zero is found
                if (matrix[i][j] == 0) {
                    markRow(matrix, n, m, i);  // Mark the entire row
                    markCol(matrix, n, m, j);  // Mark the entire column
                }
            }
        }

        // Replace all marked cells (-1) with zeros // O(N*M)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Function to mark a row // O(M)
    public void markRow(int[][] matrix, int n, int m, int i) { 
        for (int j = 0; j < m; j++) {
            if(matrix[i][j] != 0){
                matrix[i][j] = -1;
            }
        }
    }

    // Function to mark a column // O(N)
    public void markCol(int[][] matrix, int n, int m, int j) { 
        for (int i = 0; i < n; i++) {
            if(matrix[i][j] != 0){
                matrix[i][j] = -1;
            }
        }
    }
}

// Better Approach
// TC: O(2*(N*M))
// SC: O(N + M)

class Solution {
    public void setZeroes(int[][] matrix) {
        // Better Approach

        int n = matrix.length;
        int m = matrix[0].length;

        // Boolean arrays to mark rows and columns that need to be set to zero
        boolean row[] = new boolean[n];
        boolean col[] = new boolean[m];

        // Traverse the matrix to find zeros and mark the corresponding row and column //O(N*M)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Set matrix cells to zero if the corresponding row or column is marked //O(N*M)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

// Optimal Approach
// TC: O(2*(N*M))
// SC: O(1)

class Solution {
    public void setZeroes(int[][] matrix) {
        // Optimal Approach

        int n = matrix.length;
        int m = matrix[0].length;

        // Variable to track if the first column needs to be zeroed
        int col0 = 1;

        // Traverse the matrix to mark zeros in the first row and first column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;  // Mark the first cell of the row
                    if (j != 0) {
                        matrix[0][j] = 0;  // Mark the first cell of the column
                    } else {
                        col0 = 0;  // If the zero is in the first column, set col0 to 0
                    }
                }
            }
        }

        // Traverse the matrix from the second row and second column to set zeros
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // If the first cell of the first row is zero, set the entire first row to zero
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // If col0 is zero, set the entire first column to zero
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
