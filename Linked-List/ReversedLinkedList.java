/* Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both? */

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
public class ReversedLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode rList = new ListNode();
        ListNode iterator = rList;
        int n = countDepth(head);
        int[] listArray = new int[n];
        int i = 0;

        if(head == null) return null;
        
        while(head != null) {
            listArray[i] = head.val;
            head = head.next;
            i++;
        }
        
        for (int j = n - 1; j >= 0; j--) {
            iterator.val = listArray[j];
            if(iterator.next == null && j != 0) iterator.next = new ListNode();
            iterator = iterator.next;
        }
        return rList;
    }

    public int countDepth(ListNode head) {
        int depth = 0;
        while(head != null) {
            depth++;
            head = head.next;
        }
        return depth;
    }
}