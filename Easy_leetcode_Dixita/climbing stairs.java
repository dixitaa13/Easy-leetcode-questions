70. Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Solution 1: Recursion tc: O(2^n)   sc: o(n)
class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1) return 1;
        return climbStairs(n-1)+climbStairs(n-2);
    }
}

Solution 2: DP(Memo)  tc: O(n)  sc: O(n)

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }

    public int helper(int n, int[] dp){
        if(n==0 || n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=helper(n-1,dp)+helper(n-2,dp);
    }
}

Solution 3: DP(Tabulation) tc: O(N)  sc: O(N)
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}


Solution 4: DP(Space Optimized)  tc: O(N)    sc: O(1)
class Solution {
    public int climbStairs(int n) {
        int prev = 1;
        int curr = 1;
        for(int i=2;i<=n;i++){
            int temp = curr;
            curr = prev+curr;
            prev = temp;
        }
        return curr;
    }
}