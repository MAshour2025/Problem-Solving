/*
 * LeetCode 82. Remove Duplicates from Sorted List II
 *
 * Topic: Linked List
 * Difficulty: Medium
 * *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Link:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
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
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy.next;
        ListNode slow = dummy;

        // Indicates whether the current value has duplicates
        boolean flag = false;

        while (fast != null) {

            // Move fast to the last node of the duplicate group
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;
                flag = true;
            }

            if (flag) {

                // Skip the entire duplicate group
                slow.next = fast.next;
                flag = false;

            } else {

                // Current node is unique
                slow = slow.next;
            }

            fast = fast.next;
        }

        return dummy.next;
    }
}

public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}
