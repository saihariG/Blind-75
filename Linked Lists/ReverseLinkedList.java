/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
 *  Algorithm to reverse a linked list
     1. create nodes current and prev while current points to head
     2. Temporarily store the next_node (head's next)
     3. Reverse the link
     4. Move previous and current one step ahead
     5. Update the head to the new first node which is previous
 * 
 * 
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while(current != null) {
            ListNode nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        return previous;
    }
}