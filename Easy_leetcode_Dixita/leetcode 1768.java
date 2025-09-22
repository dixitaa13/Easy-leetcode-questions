1768. Merge Strings Alternately
You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
Return the merged string.

Example 1:
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Example 2:
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s

Example 3:
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d

Solution 1: tc: O(N^2)     sc: O(N)
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        String s = "";
        while(i<word1.length() && j<word2.length()){
            s+=word1.charAt(i++);
            s+=word2.charAt(j++);
        }
        while(i<word1.length()) s+=word1.charAt(i++);
        while(j<word2.length()) s+=word2.charAt(j++);
        return s;
    }
}

Solution 2: tc: O(N)    sc: O(N)
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        StringBuilder s = new StringBuilder(word1.length()+word2.length());
        while(i<word1.length() && j<word2.length()){
            s.append(word1.charAt(i++));
            s.append(word2.charAt(j++));
        }
        while(i<word1.length()) s.append(word1.charAt(i++));
        while(j<word2.length()) s.append(word2.charAt(j++));
        return s.toString();
    }
}

Solution 3: tc: O(N)    sc: O(N)  more optimized than solution 2
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        int k = 0;
        char[] ch = new char[word1.length()+word2.length()];
        while(i<word1.length() && j<word2.length()){
            ch[k++] = word1.charAt(i++);
            ch[k++] = word2.charAt(j++);
        }
        while(i<word1.length()) ch[k++] = word1.charAt(i++);
        while(j<word2.length()) ch[k++] = word2.charAt(j++);
        return new String(ch);
    }
}