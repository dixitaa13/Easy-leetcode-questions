53. Maximum Subarray
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


Solution 1: tc: O(N^3) sc: O(1)
class Solution {
    public int maxSubArray(int[] nums) {
       int max = Integer.MIN_VALUE;
       int sum = 0;
       for(int i=0;i<nums.length;i++){
         for(int j=i;j<nums.length;j++){
            sum = 0;
            for(int k=i;k<=j;k++){
                sum += nums[k];
            }
            max = Math.max(max,sum);
         }
       } 

       return max;
    }
}

Solution 2: tc: O(N^2)  sc: O(1)

class Solution {
    public int maxSubArray(int[] nums) {
       int max = Integer.MIN_VALUE;
       int sum = 0;
       for(int i=0;i<nums.length;i++){
         sum = 0;
         for(int j=i;j<nums.length;j++){
            sum += nums[j];
            max = Math.max(max,sum);
         }
       } 

       return max;
    }
}

Solution 3: tc: O(N) sc: O(1)

class Solution {
    public int maxSubArray(int[] nums) {
       int max = Integer.MIN_VALUE;
       int sum = 0;
       
       for(int n: nums){
         if(sum<0) sum = 0;
         sum+=n;
         max = Math.max(max,sum);
       }

       return max;
    }
}

Solution 4: KADANE ALGORITHM tc: O(N) sc: O(1)

class Solution {
    public int maxSubArray(int[] nums) {
       int max = nums[0];
       int sum = nums[0]; //we have initialized sums with nums[0] and not 0 because then for negative arrays it will not work properly and on comparison will always return empty subarray
       
       for(int i=1;i<nums.length;i++){
         sum = Math.max(nums[i],nums[i]+sum); // we haven't compared it with sum bcz then we will be comparing like i-1 and i and now we are comparing like if nums[i] is alone sufficient like for negative subarrays
         max = Math.max(max,sum);
       }

       return max;
    }
}