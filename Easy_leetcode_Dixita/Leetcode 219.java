219. Contains Duplicate II
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false


Solution 1: tc: O(N^2)  sc: O(1)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j] && Math.abs(i-j)<=k)return true;
            }
        }

        return false;
    }
}

Solution 2: tc: O(N)   sc: O(min(n,k))
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(i>k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        } 

        return false;
    }
}

Explaination:
meaning of if(i>k) set.remove(nums[i-k-1]);
When we move past index k, we remove the element that is too far away from the current index (more than k distance).
This keeps the set containing at most the last k elements, so we only check for duplicates within a window of size k.

meaning of if (!set.add(nums[i])) return true;
set.add(nums[i]) tries to insert nums[i] into the set.
If nums[i] already exists in the set, add() returns false, meaning we found a duplicate within the last k elements → return true.