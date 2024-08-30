// Brute Force 
// TC: O(N2)
// SC: O(1)
class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;
        for(int i=0; i<n; i++){
            int cnt = 0;
            for(int j=0; j<n; j++){
                if(nums[i] == nums[j]){
                    cnt++;
                }
            }

            if(cnt > (n/2)){
                return nums[i];
            }
        }
        return -1;
    }
}

// Better Approach
// TC: O(N)
// SC: O(N)
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > n / 2) {
                return nums[i];
            }
        }
        return -1;
    }
}

// Optimal Approach: Moore’s Voting Algorithm
// TC: O(2N)
// SC: O(1)
class Solution {
    public int majorityElement(int[] nums) {
       
        int n = nums.length;
        int cnt = 0; // count
        int el = 0; // Element

        //applying the algorithm:
        for (int i = 0; i < n; i++) {

            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            } 
            else if (el == nums[i]) cnt++;
            else cnt--;
        }

        // checking if the stored element
        // is the majority element:
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el) cnt1++;
        }

        if (cnt1 > (n / 2)) return el;
        return -1;
    }
}