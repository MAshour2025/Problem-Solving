/*
 * LeetCode 92. Reverse Linked List II
 *
 * Topic: Linked List
 * Difficulty: Medium
 * *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Link:
 * https://leetcode.com/problems/reverse-linked-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev points to node before left
        ListNode prev = dummy;

        for (int i = 1; i < left; i++)
            prev = prev.next;

        // Start reversing
        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {

            ListNode next = curr.next;

            curr.next = next.next;

            next.next = prev.next;

            prev.next = next;
        }

        return dummy.next;
    }
}

public class ReverseLinkedListII_SpaceOptimized {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}
