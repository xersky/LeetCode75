/* You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 

Example 1:

Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
Explanation:
The above figure represents the given linked list. The indices of the nodes are written below.
Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
We return the new list after removing this node. 


Example 2:

Input: head = [1,2,3,4]
Output: [1,2,4]
Explanation:
The above figure represents the given linked list.
For n = 4, node 2 with value 3 is the middle node, which is marked in red.


Example 3:

Input: head = [2,1]
Output: [2]
Explanation:
The above figure represents the given linked list.
For n = 2, node 1 with value 1 is the middle node, which is marked in red.
Node 0 with value 2 is the only node remaining after removing node 1.
 

Constraints:

The number of nodes in the list is in the range [1, 105].
1 <= Node.val <= 105 */

public class DeleteTheMiddleNodeOfALinkedList {

//This Part of the code is just to test our algorithm----------------------
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { 
            this.val = val;
        }
        ListNode(int val, ListNode next) { 
            this.val = val; this.next = next; 
        }
    }
    public static ListNode injector(int[] list) {
        ListNode head = new ListNode();
        ListNode inj = head;

        for (int i = 0; i < list.length; i++) {
            inj.val = list[i];
            if(i != list.length - 1) {
                inj.next = new ListNode();
                inj = inj.next;
            }
        }
        
        return head;
    }
//-------------------------------------------------------------------------
    //solution
    public static ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        int n = countNodes(head);
        int middleIndex = n % 2 == 0 ? (n / 2) - 1 : ((n - 1) / 2) - 1;
        ListNode currentNode = head;
        
        for(int i = 0; i < n - 1; i++) {
            if(i == middleIndex) {
                currentNode.next = currentNode.next.next;
                return head;
            }
            currentNode = currentNode.next;
        }

        return head;
    }

    public static int countNodes(ListNode head) {
        int counter = 0;

        while(head != null) {
            counter++;
            head = head.next;
        }
        return counter;     
    }
    public static void main(String[] args) {
        int[] list = new int[]{1,3,4,7,1,2,6};
        ListNode head = injector(list);
        head = deleteMiddle(head);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}