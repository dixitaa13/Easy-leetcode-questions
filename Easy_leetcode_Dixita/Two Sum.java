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

Solution 1: tc: O(N^2) sc: O(2)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
    }
}

Solution2: tc: O(N)  sc: O(N)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff) && i!=map.get(diff)){
               ans[0] = i;
               ans[1] = map.get(diff);
            }
        }

        return ans;
    }
}


Solution 3: a little short version of solution 2 tc: O(N)  sc: O(N)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int diff = target - nums[i];
            if(map.containsKey(diff) && i!=map.get(diff)){
               return new int[] {i,map.get(diff)};
            }
            map.put(nums[i],i);
        }

        return new int[] {};
    }
}