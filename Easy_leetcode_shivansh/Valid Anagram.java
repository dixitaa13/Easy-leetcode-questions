Question: Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

Solution1: tc: O(N) sc: O(26)
class Solution {
    public boolean isAnagram(String s, String t) {
        // If length not equal doesn't make sense for anagram
        if(s.length() != t.length()) return false;

        // Then store frequency to check 
        Map<Character,Integer>mp1 = new HashMap<>();
        Map<Character,Integer>mp2 = new HashMap<>();

        for(int i=0;i<s.length();i++){
            mp1.put(s.charAt(i),mp1.getOrDefault(s.charAt(i),0)+1);
            mp2.put(t.charAt(i),mp2.getOrDefault(t.charAt(i),0)+1);       
        }

        return mp1.equals(mp2);


    }
}