1. Two Sum
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Solution 1: tc: O(N^2) and sc O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }
        return ans;
    }
}


Solution 2:  tc: O(N) and sc O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>mp = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int left = target-nums[i];
            if(mp.containsKey(left)){
                return new int[]{mp.get(left),i};
            }
            mp.put(nums[i],i);
        }
        return new int[]{};
    }
}