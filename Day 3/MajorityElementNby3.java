// Brute Force 
// TC: O(N2)
// SC: O(N) ( Just to return ans )

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) {
                    cnt++;
                }
            }

            if (cnt > (n / 3) && !ans.contains(nums[i])) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }
}

// Better Force 
// TC: O(N)
// SC: O(N) (Map) + O(N) ( Just to return ans )

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }
}


// Modified Moore's Voting Algorithm 
// TC: O(2N)
// SC: O(N) ( Just to return ans )
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        // Initialize elements and their counts
        int cnt1 = 0, cnt2 = 0;
        int elt1 = Integer.MIN_VALUE, elt2 = Integer.MIN_VALUE;

        // Step 1: Find potential elements using Moore's Voting Algorithm
        for (int i = 0; i < n; i++) {
            if (elt1 == nums[i]) {
                cnt1++; // Increment count for elt1
            } else if (elt2 == nums[i]) {
                cnt2++; // Increment count for elt2
            } else if (cnt1 == 0) {
                elt1 = nums[i]; // Assign elt1 if its count is 0
                cnt1 = 1;
            } else if (cnt2 == 0) {
                elt2 = nums[i]; // Assign elt2 if its count is 0
                cnt2 = 1;
            } else {
                cnt1--; // Decrease both counts if the current element matches neither
                cnt2--;
            }
        }

        // Step 2: Verify the actual counts of elt1 and elt2
        cnt1 = 0;
        cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == elt1) {
                cnt1++;
            } else if (nums[i] == elt2) { // Use "else if" to ensure elt1 and elt2 are distinct
                cnt2++;
            }
        }

        // Step 3: Add elements to the result if they appear more than n / 3 times
        int mini = n / 3;
        if (cnt1 > mini) {
            ans.add(elt1);
        }
        if (cnt2 > mini) {
            ans.add(elt2);
        }

        return ans;
    }
}
