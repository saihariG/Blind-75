/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /*
        Algorithm:
        1. If either of the list is null, return the other list's head (Since the list is already sorted)
        2. Create two nodes pointing to given heads of the two lists respectively
        3. Initialize nodes head and tail to null
        4. compare the nodes in both the lists and assign the head and tail accordingly
        5. Traverse while both the nodes are not null
        6. Again, compare and assign the tail accordingly and traverse... until the loop terminates
        7. Check if we have traversed the first list completely. If yes, assign the tail's next to current2 (In essence, merging the other list), else Vice versa.
        8. Return the head 
    */
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        ListNode current1 = head1;
        ListNode current2 = head2;

        ListNode head = null, tail = null;

        if(current1.val <= current2.val) {
            head = current1;
            tail = current1;
            current1 = current1.next;
        } else {
            head = current2;
            tail = current2;
            current2 = current2.next;
        }

        while(current1 != null && current2 != null) {
            if(current1.val <= current2.val) {
                tail.next = current1;
                tail = current1;
                current1 = current1.next;
            } else {
                tail.next = current2;
                tail = current2;
                current2 = current2.next;
            }
        }

        if(current1 == null) {
            tail.next = current2;
        } else {
            tail.next = current1;
        }

        return head;
    }

    public ListNode mergeTwoListsRecursive(ListNode head1, ListNode head2) { 

        if(head1 == null) return head2;
        if(head2 == null) return head1;
        
        if(head1.val < head2.val) {
            head1.next = mergeTwoListsRecursive(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoListsRecursive(head1, head2.next);
            return head2;
        }
    }
}