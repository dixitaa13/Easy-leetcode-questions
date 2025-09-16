1523. Count Odd Numbers in an Interval Range
Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

Example 1:
Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].

Example 2:
Input: low = 8, high = 10
Output: 1
Explanation: The odd numbers between 8 and 10 are [9].

Constraints:
0 <= low <= high <= 10^9

Solution 1: tc: O(N)   sc: O(1)
class Solution {
    public int countOdds(int low, int high) {
       int count =0;
       while(low<=high){
        if(low%2!=0) count++;
        low+=1;
       } 

       return count;
    }
}


Solution 2: tc: O(1)    sc: O(1)
class Solution {
    public int countOdds(int low, int high) {
       return (high+1)/2-(low/2);
    }
}

(high+1)/2 → counts how many odd numbers are ≤ high.
(low)/2 → counts how many odd numbers are < low.
(Because dividing low by 2 with integer division effectively counts odds before low).
So subtracting gives the number of odds between low and high inclusive.