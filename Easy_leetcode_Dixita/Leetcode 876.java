876. Middle of the Linked List
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

Solution 1: 2 pass tc: O(N)   sc: O(1)
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        int i=0;
        while(i<count/2){
           temp = temp.next;
           i++;
        }

        return temp;
    }
}


Solution 2: tc: O(N)  sc: O(1)
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}