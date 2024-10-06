// Brute Force 
// TC: O(n2)
// SC: O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int curr = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == curr) {
                    return curr;
                }
            }
        }

        return -1; // We won't reach here if in every test case
        // we have atleast 1 duplicate element
    }
}

// NOTE: TLE

// Better Force 
// TC: O(2N)
// SC: O(N)
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        int[] freqArray = new int[n];

        for(int i=0; i<n; i++){
            freqArray[nums[i]]++;
        }

        for(int i=0; i<n; i++){
            if(freqArray[i] > 1){
                return i;
            }
        }

        return -1;
    }
}

// Optimal Approach 
// TC: O(N)
// SC: O(1)

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Detecting the Cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Finding the Entry Point of the Cycle
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}