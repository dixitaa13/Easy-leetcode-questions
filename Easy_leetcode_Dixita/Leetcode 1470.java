1470. Shuffle the Array
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn].

Example 1:
Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7] 
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

Example 2:
Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]

Example 3:
Input: nums = [1,1,2,2], n = 2
Output: [1,2,1,2]

Constraints:
1 <= n <= 500
nums.length == 2n
1 <= nums[i] <= 10^3

Solution 1: tc: O(2*n)   sc: O(2*n)
class Solution {
    public int[] shuffle(int[] nums, int n) {
       int[] res = new int[2*n];
       int i = 0;
       int j = n;
       int idx = 0;
       while(i<n && j<2*n){
          res[idx++] = nums[i++];
          res[idx++] = nums[j++];
       }

       return res;
    }
}

Solution 2:  tc: O(2*n)    sc: O(1)
class Solution {
    public int[] shuffle(int[] nums, int n) {
       int M = 10000;
       for(int i=0;i<n;i++){
        nums[i] = nums[i]+nums[i+n]*M;
       }

       int idx = 2*n-1;
       for(int i=n-1;i>=0;i--){
        int y = nums[i]/M;
        int x = nums[i]%M;
        nums[idx--]=y;
        nums[idx--] = x;
       }

       return nums;
    }
}

Explaination:
Logic: nums = [2,5,1,3,4,7]
Choose a multiplier M greater than the maximum element in nums.
Step 1: For each i in 0..n-1, encode xi and yi into nums[i] as
nums[i] = xi + yi * M => 2+3*10000 = 30002

This packs both numbers into a single integer.
Step 2: Iterate i from n-1 down to 0 and decode values using:
y = nums[i] / M => 30002/10000 = 3
x = nums[i] % M => 30002%10000 = 2

Place them at the end of the array (idx decreasing).
This gives the final interleaved order [x1,y1,x2,y2,...,xn,yn] in-place with no extra array.
