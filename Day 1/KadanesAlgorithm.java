// Brute Force
// TC: O(N3)
// SC: O(1)

class Solution {
    public int maxSubArray(int[] nums) {

        int maxi = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxi = Math.max(sum, maxi);
            }
        }

        return maxi;
    }
}

// Better Force
// TC: O(N2)
// SC: O(1)

class Solution {
    public int maxSubArray(int[] nums) {

        int maxi = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
                int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                maxi = Math.max(sum, maxi);
            }
        }

        return maxi;
    }
}

// Optimal Approach
// TC: O(N)
// SC: O(1)

class Solution {
    public int maxSubArray(int[] nums) {

        int n = nums.length;
        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;

        for (int i = 0; i < n; i++) {

            sum += nums[i];

            if (sum > maxi) {
                maxi = sum;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }
        return (int)maxi;
    }
}