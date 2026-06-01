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

        ListNode current = head;
        int size=0;
        while (current != null) {
            size++;
            current = current.next;            
        }

        if(size == 1)
            return null;
        if(size-n == 0)
            return head.next;

        current = head;
        for(int i=0; i<size-n-1;i++)
        {
            current = current.next;       
        }
        current.next=current.next.next;
        return head;
    }
}
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}
