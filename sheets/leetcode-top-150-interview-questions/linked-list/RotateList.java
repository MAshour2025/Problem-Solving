/*
 * LeetCode 61. Rotate List
 *
 * Topic: Linked List
 * Difficulty: Medium
 * *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Link:
 * https://leetcode.com/problems/rotate-list/description/?envType=study-plan-v2&envId=top-interview-150
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
    public ListNode rotateRight(ListNode head, int k) {

        // Empty list
        if (head == null)
            return head;

        // Calculate list length
        int size = 0;
        ListNode current = head;

        while (current != null) {
            size++;
            current = current.next;
        }

        // Rotating by size gives the same list
        k %= size;

        if (k == 0)
            return head;

        // Index of the new tail after rotation
        int cutPointIndex = size - k - 1;

        ListNode tail = head;
        ListNode newTail = null;
        ListNode newHead = null;

        int index = 0;

        // Find:
        // 1. The current tail
        // 2. The new tail and new head
        while (tail.next != null) {

            if (index == cutPointIndex) {
                newTail = tail;
                newHead = tail.next;
            }

            tail = tail.next;
            index++;
        }

        tail.next = head;
        // Break the circle at the new tail
        newTail.next = null;

        return newHead;
    }
}

public class RotateList {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}