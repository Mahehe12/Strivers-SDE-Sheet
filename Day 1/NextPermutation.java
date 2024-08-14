class Solution {
    // Brute Force

    /*
     * 1. Generate all permutations (Takes TC around O(N! * N))
     * 2. Do a linear search and find our nums
     * 3. Return next permutation
     */

    // Optimal Approach

    // TC: O(3N)
    // SC: O(1)
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // Find longer prefix
        int idx = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i; // Found a break point (eg: [1, 2, 3, 4 / 5])
                break;
            }
        }

        if (idx == -1) { // We didn't find a break point
            reverse(nums, 0, n - 1);
            return;
        }

        // Now we gotta find number that is just greater
        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                swap(nums, i, idx);
                break;
            }
        }

        // Now replace the reamaining elemnts in sorted order
        reverse(nums, idx + 1, n - 1);
    }

    private void reverse(int[] nums, int st, int end) {
        while (st < end) {
            swap(nums, st, end);
            st++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}