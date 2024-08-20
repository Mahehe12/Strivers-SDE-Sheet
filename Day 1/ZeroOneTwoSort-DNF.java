class Solution {
    public void sortColors(int[] nums) {
        // Brute Force is to simply use the library function to sort the array
        // TC: O( NlogN )

        // Better Approach
        // O(2N)
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt0++;
            } else if (nums[i] == 1) {
                cnt1++;
            } else if (nums[i] == 2) {
                cnt2++;
            }
        }

        for (int i = 0; i < cnt0; i++) {
            nums[i] = 0;
        }

        for (int i = cnt0; i < cnt0 + cnt1; i++) {
            nums[i] = 1;
        }

        for (int i = cnt0 + cnt1; i < nums.length; i++) {
            nums[i] = 2;
        }
    }
}

// TC : O(N)
// Sc : O(1)
class Solution {
    public void sortColors(int[] nums) {
        /*
         * Optimal Approach
         * Dutch National Flag Algorithm
         * 3 variables ( low, mid, high )
         * 3 Rules : 
         * 1. 0 ..... (low - 1) -> 0 Extreme Left
         * 2. low ..... (mid - 1) -> 1
         * 3. (high + 1) ...... (n - 1) -> 2 Extreme Right
         * 00000 (low - 1) (low) 1111111 (mid - 1) (mid) 0/1/2 (high) (high + 1) 222222 (n - 1)
         * Unsorted from mid to high [0/1/2]
         */

        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}