// TC: O(N)
// SC: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        // My Approach
        // Start by assuming the first price as the buying price.
        // Traverse through the array, updating maxProfit whenever selling at current price yields a higher profit.
        // If the current price is lower than the buying price, update buyPrice to the current price.
        // This ensures we always buy at the lowest price seen so far and sell at the highest price after it.
        
        int buyPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(profit, maxProfit);
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}

// TC: O(N)
// SC: O(1)

class Solution {
    // Dynamic Programming Approach
    // Inutution: If we are selling on ith day we have to buy 
    // At minimum price from 1 -> (i - 1)

    public int maxProfit(int[] prices) {
        int minBuyPrice = prices[0];
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++){
            int profit = prices[i] - minBuyPrice;
            maxProfit = Math.max(profit, maxProfit);
            minBuyPrice = Math.min(minBuyPrice, prices[i]); // We are remembering the last min Buy Price 
        }

        return maxProfit;
    }
}