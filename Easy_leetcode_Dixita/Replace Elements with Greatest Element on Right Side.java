1299. Replace Elements with Greatest Element on Right Side
Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
After doing so, return the array.

Example 1:
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation: 
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.

Example 2:
Input: arr = [400]
Output: [-1]
Explanation: There are no elements to the right of index 0.

Solution 1: Brute tc: O(N^2)   sc: O(1)
public int[] replaceElements(int[] arr) {
    int n = arr.length;
    for(int i = 0; i < n; i++) {
        int max = -1;
        for(int j = i+1; j < n; j++) {
            max = Math.max(max, arr[j]);
        }
        arr[i] = max;
    }
    return arr;
}

Explaination:
arr = [17, 18, 5, 4, 6, 1]
i=0: look at [18, 5, 4, 6, 1] → max=18 → arr[0]=18
i=1: look at [5, 4, 6, 1] → max=6 → arr[1]=6
i=2: look at [4, 6, 1] → max=6 → arr[2]=6
i=3: look at [6, 1] → max=6 → arr[3]=6
i=4: look at [1] → max=1 → arr[4]=1
i=5: nothing to the right → max=-1 → arr[5]=-1

Solution 2: tc: O(N)  sc: O(N)

class Solution {
    public int[] replaceElements(int[] arr) {
       int n = arr.length;
       int[] result = new int[n];
       result[n-1] = -1;

       for(int i=n-2;i>=0;i--){
          result[i] = Math.max(arr[i+1],result[i+1]);
       }

       return result;
    }
}

Explaination:
here we are just comparing the elements like last element of arr and result, then second last, third last while keeping i one before as last element will be -1

Solution 3: tc: O(N)   sc: O(1)
class Solution {
    public int[] replaceElements(int[] arr) {
       int temp = 0;
       int max = -1;

       for(int i=arr.length-1;i>=0;i--){
          temp = arr[i];
          arr[i] = max;

          if(temp>max)  max = temp;
       }

       return arr;
    }
}

Explaination:
here we are just storing of arr in temp and in arr putting value of max and checking if temp>max put value of temp in max
