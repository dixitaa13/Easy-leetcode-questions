198. House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

Solution 1: Recursion tc: O(2^n) sc: O(N)

class Solution {
    public int rob(int[] nums) {
        return helper(nums,0);
    }

    public int helper(int[] nums, int i){
        if(i>=nums.length) return 0;

        int rob = nums[i]+helper(nums,i+2);
        int skip = helper(nums,i+1);

        return Math.max(rob,skip);
    }
}


Solution 2: DP(Memo) tc: O(N)  sc: O(N)

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }

    public int helper(int[] nums, int i, int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];

        int rob = nums[i]+helper(nums,i+2,dp);
        int skip = helper(nums,i+1,dp);

        return dp[i]=Math.max(rob,skip);
    }
}

Solution 3: Dp(Tabulation)  tc: O(N)     sc: O(N)

class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);

        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }

        return dp[nums.length-1];
    }
}

Solution 4: Dp(Space optimized)  tc: O(N)   sc: O(1)

class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        int prev2 = 0;
        int prev1 = nums[0];

        for(int i=1;i<nums.length;i++){
            int rob = nums[i]+prev2;
            int skip = prev1;
            int curr = Math.max(rob,skip);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
