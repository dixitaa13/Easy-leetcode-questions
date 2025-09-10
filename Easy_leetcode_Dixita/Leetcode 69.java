69. Sqrt(x)
Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator.
For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

Example 1:
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.

Solution 1: tc: O(sqrt x)  sc: O(1)
class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1) return x;
        int i = 1;
        int ans = 0;
        
        while(i<=x/i){
           i++;
        }

        return i-1;
    }
}


Solution 2: tc: O(log n)   sc: O(1)
class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1) return x;
        int i = 1;
        int j = x;
        int mid = -1;
        int ans = 0;
        while(i<=j){
          mid = i+(j-i)/2;
          if(mid>x/mid) j = mid-1;
          else if(mid<x/mid) {
            ans = mid;
            i = mid+1;
          }
          else return mid;
        }

        return ans;
    }
}



Explaination: 
In this we are just simply using binary search to traverse through 1 to n and find the element that can be square root of n and to store floor value we will store the largest mid such that mid*mid<=n