121. Best Time to Buy and Sell Stock
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Solution 1: tc: O(N^2)     sc: O(1)
class Solution {
    public int maxProfit(int[] prices) {
       int max = 0;

       for(int i=0;i<prices.length;i++){
         for(int j=i+1;j<prices.length;j++){
            int profit = prices[j]-prices[i];
            if(profit>max){
                max = profit;
            }
         }
       }
       return max;
    }
}

Solution2: Optimized solution tc: O(N)   sc: O(1)

Thinking behind this: we will buy the stocks at the 0th day then we will find if there is any day when we can buy cheaper stocks and then we will buy it and try to calculate the max profit with next preceeding days

class Solution {
    public int maxProfit(int[] prices) {
       int buy = prices[0];
       int profit = 0;

       for(int i=1;i<prices.length;i++){
         if(prices[i]<buy){
            buy = prices[i];
         }
         profit = Math.max(profit,prices[i]-buy);
       }
       return profit;
    }
}