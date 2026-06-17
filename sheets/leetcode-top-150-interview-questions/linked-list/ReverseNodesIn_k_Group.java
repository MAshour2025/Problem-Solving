/*
 * LeetCode 25. Reverse Nodes in k-Group
 *
 * Topic: Linked List
 * Difficulty: Hard
 * *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Link:
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-interview-150
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
    public ListNode reverseKGroup(ListNode head, int k) {

        // No need to reverse if group size is 1
        if (k == 1)
            return head;

        // Calculate linked list length
        int size = 0;
        ListNode current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        // Dummy node to simplify handling the first group
        ListNode dummy = new ListNode();
        dummy.next = head;

        // prev points to the node before the current group
        ListNode prev = dummy;
        current = head;

        // Process only complete groups of size k
        while (size >= k) {

            // Reverse current group using Head Insertion
            int groupReverseIterations = k - 1;

            while (groupReverseIterations-- > 0) {

                // Extract node after current
                ListNode next = current.next;

                // Remove next from its current position
                current.next = next.next;

                // Insert next at the beginning of the group
                next.next = prev.next;
                prev.next = next;
            }

            // Move to the next group
            prev = current;
            current = current.next;

            // k nodes have been processed
            size -= k;
        }

        return dummy.next;
    }
}

public class ReverseNodesIn_k_Group {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}

