234. Palindrome Linked List
Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false

Solution 1: tc: O(N)   sc: O(N)
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null){
           list.add(head.val);
           head = head.next;
        }

        int e = list.size()-1;
        int s = 0;

        while(s<=e){
            if(list.get(s)!=list.get(e)) return false;
            s++;
            e--;
        }

        return true;
    }
}


Solution 2: tc: O(N)  sc: O(1)

class Solution {
    public boolean isPalindrome(ListNode head) {
       ListNode slow = head;
       ListNode fast = head;

       while(fast!=null && fast.next!=null){
           slow = slow.next;
           fast = fast.next.next;
       } 

       ListNode prev = null;
       while(slow!=null){
          ListNode temp = slow.next;
          slow.next = prev;
          prev = slow;
          slow = temp;
       }

       ListNode first = head;
       ListNode second = prev;

       while(second!=null){
          if(second.val!=first.val) return false;
          second = second.next;
          first = first.next;
       }

       return true;
    }
}

Steps for solution 2:
1. Find the middle of the list  ------> O(N/2) worst: O(N)
2. Reverse the second half of the list  ------> O(N/2)  worst: O(N)
3. Start comparing each node of the list ------> O(N/2)   worst: O(N)

These will be 2 lists created and loop has ran until second!=null due to odd cases and in that second list will contain one extra node
First half: 1 → 2
Second half (reversed): 1 → 2 → 3
