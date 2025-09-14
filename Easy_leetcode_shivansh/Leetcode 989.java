The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

 

Example 1:

Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
Example 2:

Input: num = [2,7,4], k = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
Example 3:

Input: num = [2,1,5], k = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
 

Constraints:

1 <= num.length <= 104
0 <= num[i] <= 9
num does not contain any leading zeros except for the zero itself.
1 <= k <= 104


Solution 1 
Tc : O(max(N,logk))
Sc : O(max[N,logk])
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int len = num.length-1;
        int carry =0,sum=0;
        List<Integer> list = new ArrayList<>();
        int x=0,y=0;
        while(k>0 || len>=0 || carry>0){
            x = (len>=0) ? num[len] : 0;
            y = k%10;
            sum = x+y+carry;
            list.add(sum%10);
            carry = sum/10;
            k = k/10;
            len--;
        }
        Collections.reverse(list);
        return list;
    }
}

Solution 2
Tc: O(N)
Sc: O(N)

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int i = num.length - 1;
        int carry = 0;
        
        while (i >= 0 || k > 0 || carry > 0) {
            int x = (i >= 0) ? num[i] : 0;
            int y = k % 10;
            int sum = x + y + carry;
            
            list.addFirst(sum % 10);  // no need to reverse later
            carry = sum / 10;
            k /= 10;
            i--;
        }
        return list;
    }
}
