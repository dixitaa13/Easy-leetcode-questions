1822. Sign of the Product of an Array
Implement a function signFunc(x) that returns:
1 if x is positive.
-1 if x is negative.
0 if x is equal to 0.
You are given an integer array nums. Let product be the product of all values in the array nums.
Return signFunc(product).

Example 1:
Input: nums = [-1,-2,-3,-4,3,2,1]
Output: 1
Explanation: The product of all values in the array is 144, and signFunc(144) = 1

Example 2:
Input: nums = [1,5,0,2,-3]
Output: 0
Explanation: The product of all values in the array is 0, and signFunc(0) = 0

Example 3:
Input: nums = [-1,1,-1,1,-1]
Output: -1
Explanation: The product of all values in the array is -1, and signFunc(-1) = -1

Solution 1: tc: O(N)    sc: O(1)  This will give overflow error resulting in wrong answer
class Solution {
    public int arraySign(int[] nums) {
       int n = nums.length;
       int product = 1;
       for(int i=0;i<n;i++){
        product = product*nums[i];
       } 
       if (product==0) return 0;
       return product<0?-1:1;
    }
}


Solution 2:  tc: O(N)    sc: O(1)
class Solution {
    public int arraySign(int[] nums) {
       int n = nums.length;
       int product = 1;
       for(int i=0;i<n;i++){
         if(nums[i]==0) return 0;
         if(nums[i]<1) product = -product;
       } 
       return product;
    }
}

Solution 3: More efficient then solution 2  tc: O(N)   sc: O(1)
class Solution {
    public int arraySign(int[] nums) {
       int count = 0;
       for(int i=0;i<nums.length;i++){
         if(nums[i]==0) return 0;
         if(nums[i]<1) count++;
       } 
       return count%2!=0?-1:1;
    }
}