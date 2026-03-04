package leetcode.Array;

// LC: 121. Best Time to Buy and Sell Stock

class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int min = prices[0];

        for(int i=1;i<prices.length;i++){
            if(min>prices[i]){
                min = prices[i];
            }

            int profit = prices[i] - min;

            if(profit>maxprofit){
                maxprofit = profit;
            }
        }

        return maxprofit;
    }
}
