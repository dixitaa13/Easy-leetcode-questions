20. Valid Parenthese
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 
Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Example 5:
Input: s = "([)]"
Output: false

Solution 1: tc: O(N)  sc: O(N)
class Solution {
    public boolean isValid(String s) {
       Stack<Character> st = new Stack<>();

       for(int i=0;i<s.length();i++){
         if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
            st.push(s.charAt(i));
         }
         else if(!st.isEmpty() && ((st.peek()=='(' && s.charAt(i)==')') || (st.peek()=='{' && s.charAt(i)=='}') || (st.peek()=='[' && s.charAt(i)==']'))){
            st.pop();
         }
         else{
            return false;
         }
    }

    return st.isEmpty();
}
}


Solution 2: Tc: O(N)   sc: O(N)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');

        for(char ch: s.toCharArray()){
            if(map.containsValue(ch)){
                st.push(ch);
            }
            else if(map.containsKey(ch)){
              if(st.isEmpty() || map.get(ch)!=st.pop()){ // in this line we are checking as '(' != '[' if value of closing bracket == pop value
                return false;
            }
            }
        }

        return st.isEmpty();
    }
}