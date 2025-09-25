2215. Find the Difference of Two Arrays
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

Example 1:
Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums1. Therefore, answer[1] = [4,6].

Example 2:
Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].

Solution 1: tc: O(N+M)    sc: O(N+M)
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++){
            set2.add(nums2[i]);
        }

        List<Integer> result1 = new ArrayList<>();
        for(int num:set1){
            if(!set2.contains(num)) result1.add(num);
        }

        List<Integer> result2 = new ArrayList<>();

        for(int num:set2){
            if(!set1.contains(num)) result2.add(num);
        }
       
       List<List<Integer>> result = new ArrayList<>();
       result.add(result1);
       result.add(result2);

        return result;
    }
}

Solution 2: tc: O(N+M)   sc: O(N+M)
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            set1.add(nums1[i]);
        }

        for(int i=0;i<nums2.length;i++){
            set2.add(nums2[i]);
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for(int num:set1){
            if(!set2.contains(num)) result.get(0).add(num);
        }

        for(int num:set2){
            if(!set1.contains(num)) result.get(1).add(num);
        }

        return result;
    }
}