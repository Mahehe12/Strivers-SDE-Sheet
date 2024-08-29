// Brute Force 
// TC: O( m * n )
// SC: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == target){
                    return true;
                }
            }
        }

        return false;
    }
}

// Better Approach
// TC: O(N + logM)
// SC: O(1)

class Solution {
    
    
    private boolean binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return true;
            else if (target > nums[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][m - 1]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }
}

// Most Optimal 
// TC: O(log(m * n))
// SC: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        // Idea is to remember a formula row = i / n & col = i % n 2D -> 1D
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = (m * n) - 1;

        while(low <= high){
            int mid = (low + high)/2;

            int row = mid / n;
            int col = mid % n;

            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] > target){
                high = mid -1;
            }
            else{
                low = mid + 1;
            }
        }
        return false;
    }
}