303. Range Sum Query - Immutable
Given an integer array nums, handle multiple queries of the following type:
Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:
NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

Example 1:
Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]
Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

Solution 1: Brute sc: O(1)  tc: O(N)   here per query it will take O(q*n)
class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
       this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
       int sum = 0;
       for(int i=left;i<=right;i++){
        sum+=nums[i];
       } 
       return sum;
    }
}

Solution 2: Optimized: tc: O(N)    sc: O(N)  but in original per query it will take O(q+n);
class NumArray {
    int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length+1];
       for(int i=0;i<nums.length;i++){
          prefix[i+1] = prefix[i]+nums[i];
       }
    }
    
    public int sumRange(int left, int right) {
       return prefix[right+1]-prefix[left];
    }
}

Explaination:
nums=[1,2,3,4,5]
prefixSum[0] = 0
prefixSum[1] = 1         (nums[0])
prefixSum[2] = 3         (nums[0] + nums[1])
prefixSum[3] = 6         (nums[0] + nums[1] + nums[2])
prefixSum[4] = 10        (nums[0] + nums[1] + nums[2] + nums[3])
prefixSum[5] = 15        (nums[0] + nums[1] + nums[2] + nums[3] + nums[4])
so sum(0,3) = 10-1 = 9