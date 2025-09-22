1071. Greatest Common Divisor of Strings
For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""

Solution 1: 
| Step                   | Time Complexity        | Space Complexity   |
| ---------------------- | ---------------------- | ------------------ |
| Concatenation & equals | **O(len1 + len2)**     | O(len1 + len2)     |
| GCD computation        | O(log(min(len1,len2))) | O(1)               |
| Substring creation     | O(gcdLength)           | O(gcdLength)       |
| **Overall**            | **O(len1 + len2)**     | **O(len1 + len2)** |

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";

        int gcdlength = gcd(str1.length(),str2.length());
        return str1.substring(0,gcdlength);
    }

    public int gcd(int a, int b){
        return b==0?a:gcd(b, a%b);
    }
}

Explaination: For gcd function
(b == 0) ? a : ... → This is the ternary operator (short if-else).
If b == 0, we stop recursion and return a (because that's the GCD).
Otherwise, we recursively call gcd(b, a % b).

Let's compute gcd(48, 18) step by step:
b = 18 (not zero) → go to recursive call:
gcd(48, 18) → gcd(18, 48 % 18)
48 % 18 = 12
so → gcd(18, 12)

b = 12 (not zero):
gcd(18, 12) → gcd(12, 18 % 12)
18 % 12 = 6
so → gcd(12, 6)

b = 6 (not zero):
gcd(12, 6) → gcd(6, 12 % 6)
12 % 6 = 0
so → gcd(6, 0)

b = 0, so we return 6 → that's the GCD.
