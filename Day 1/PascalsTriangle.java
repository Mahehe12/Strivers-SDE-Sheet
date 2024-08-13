// Brute Force
// TC: O(n*n*r) ~ O(n3)
// SC: O(1)

public class PascalTriangle {

    /**
     * Calculates the binomial coefficient C(n,r).
     * Time Complexity: O(r)
     * Space Complexity: O(1)
     */
    public static int binomialCoeff(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    /**
     * Prints Pascal's Triangle up to n rows.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static  printPascalTriangle(int n) {
	List<List<Integer>> ans = new ArrayList<>();
        // No. of lines
        for (int i = 0; i < n; i++) {
		List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                temp.add(binomialCoeff(i, j));
            }
            ans.add(temp);
        }
    }
}


// Optimal Approach
// TC: O(N2)
// SC: O(1)

class PascalTriangle {
    /**
     * Generates a specific row of Pascal's Triangle.
     * Time Complexity: O(n*r)
     * Space Complexity: O(1)
     */
    public List<Integer> generateRow(int row) {
        List<Integer> ansRow = new ArrayList<>();
        long ans = 1;
        
        // The first element of each row is always 1
        ansRow.add(1);
        
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col);
            ans = ans / col;
            ansRow.add((int) ans); // Cast to int to avoid long overflow
        }
        
        return ansRow;
    }

    /**
     * Generates Pascal's Triangle up to numRows.
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 1; i <= numRows; i++) {
            ans.add(generateRow(i));
        }
        
        return ans;
    }
}