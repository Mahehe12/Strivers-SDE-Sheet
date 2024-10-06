class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Brute Force
        // TC: O(N2)
        // SC: O(1) [Extra Space]
        
        int n = nums.length;
        int[] ans = new int[2];

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Better Force
        // TC: O(N)
        // SC: O(N) [Extra Space]

        int n = nums.length;
        int[] ans = new int[2];
        Map<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int diff = target - nums[i];

            if(mpp.containsKey(diff)){
                ans[0] = mpp.get(diff);
                ans[1] = i;
            }else {
                mpp.put(nums[i], i);
            }

        }

        return ans;
    }
}

NOTE: For Two Sum problem, we need original indices HashMap solution is more appropriate
        
// But if you want to use two-pointer, here's how:

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Optimal Approach - 2 pointer
        // TC: O(N)
        // SC: O(1) [Extra Space]

        int n = nums.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] { nums[i], i }; // {value, original_index}
        }

        // Sort the array
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int l = 0;
        int r = n - 1;

        while (l < r) {
            int sum = pairs[l][0] + pairs[r][0];
            if (sum == target) {
                return new int[] { pairs[l][1], pairs[r][1] }; // return original indices
            }
            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return new int[]{}; // No solution found
    }
}