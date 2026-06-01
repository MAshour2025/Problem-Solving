/*
 * LeetCode 19. Remove Nth Node From End of List
 *
 * Topic: Linked List
 * Difficulty: Medium
 * *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Link:
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-interview-150
 */

import java.util.*;

// Definition for singly-linked list.
// commit this class and copy code then will get accepted 
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
} 

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node handles edge cases such as removing the head
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        int counter = 0;

        while (fast != null) {

            // Keep a gap of n+1 nodes between fast and slow
            if (counter > n)
                slow = slow.next;

            fast = fast.next;
            counter++;
        }

        // slow is now pointing to the node before the target
        slow.next = slow.next.next;

        return dummy.next;
    }
}

public class RemoveNthNodeFromEndofList_OnePass {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}
