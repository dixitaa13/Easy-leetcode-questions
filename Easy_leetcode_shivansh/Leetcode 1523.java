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

Solution 1 In my mind comes this not brute force 
Tc: O(1)  Sc: O(1)
class Solution {
    public int countOdds(int low, int high) {
        if (low %2 ==0 && high%2==0){
            return (high-low)/2;
        }
        return (high-low)/2 + 1;
    }
}

// 2 3 4 5 6  6-2/2
// 2 4 5 6 7  7-2/2 + 1

// 2 3 4 5 6 7 8 9 = 9-2/2 + 1


Solution 2: Brute Force (By counting Numbers)
Tc: O(N)   Sc: O(1)

This solution gets failed 
Time Limit Exceeded
82 / 84 testcases passed
Last Executed Input
Use Testcase
low =
0
high =
1000000000

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
