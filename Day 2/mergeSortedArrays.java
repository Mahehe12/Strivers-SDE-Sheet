// TC: O(n) + O((m+n) log(m+n))
// SC: O(1)
// Brute Force - My First Approach

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m, j = 0; i < m + n && j < n; i++, j++) {
            nums1[i] = nums2[j];
        }

        Arrays.sort(nums1);
    }
}

// TC: O(m+n)
// SC: O(m+n)
// Better Force - My Second Approach

import java.util.ArrayList;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        ArrayList<Integer> ans = new ArrayList<>();
        
        // Initialize pointers
        int i = 0, j = 0;

        // Merge elements from both arrays in sorted order
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                ans.add(nums1[i]); 
                i++;
            } else {
                ans.add(nums2[j]); 
                j++;
            }
        } 

        // Add remaining elements from nums1, if any
        while (i < m) {
            ans.add(nums1[i]); 
            i++;
        }

        // Add remaining elements from nums2, if any
        while (j < n) {
            ans.add(nums2[j]); 
            j++;
        }

        // Copy the merged elements back into nums1
        i = 0;
        for (int it : ans) {
            nums1[i++] = it;
        }
    }
}

// TC: O(m + n) 
// SC: O(1)
// Optimal Approach 

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1; // Index of the last element in the initial nums1 (ignoring extra 0's)
        int r = n - 1; // Index of the last element in nums2
        int i = m + n - 1; // Index of the last position in nums1
        
        // Merge from the back to the front
        while (l >= 0 && r >= 0) {
            if (nums1[l] > nums2[r]) {
                nums1[i--] = nums1[l--];
            } else {
                nums1[i--] = nums2[r--];
            }
        }

        // If there are remaining elements in nums2, copy them
        while (r >= 0) {
            nums1[i--] = nums2[r--];
        }
    }
}