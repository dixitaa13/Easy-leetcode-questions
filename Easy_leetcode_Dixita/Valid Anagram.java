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
       if(s.length()!=t.length()) return false;
       Map<Character, Integer> map1 = new HashMap<>();
       Map<Character, Integer> map2 = new HashMap<>();

       for(int i=0;i<s.length();i++){
          map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
          map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
       } 

       return map1.equals(map2);
    }
}

Solution2: tc: O(N) sc: O(26)

class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length()!=t.length()) return false;
       
       Map<Character, Integer> map1 = new HashMap<>();

       for(int i=0;i<s.length();i++){
          map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
       } 

       for(int i=0;i<t.length();i++){
          if(!map1.containsKey(t.charAt(i)) || map1.get(t.charAt(i))==0) return false;
          map1.put(t.charAt(i),map1.get(t.charAt(i))-1);
       } 

       return true;
    }
}

Solution 3: tc: O(N)  sc: O(26)

class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length()!=t.length()) return false;
       
       int[] count = new int[26];

       for(int i=0;i<s.length();i++){
          char ch = s.charAt(i);
          count[ch-'a'] += 1;
       } 

       for(int i=0;i<t.length();i++){
          char ch = t.charAt(i);
          if(count[ch-'a']==0) return false;
          count[ch-'a'] -= 1;
       } 

       return true;
    }
}