/*
 * LeetCode 141. Linked List Cycle
 *
 * Topic: Linked List
 * Difficulty: Easy
 * *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Link:
 * https://leetcode.com/problems/linked-list-cycle/description/?envType=study-plan-v2&envId=top-interview-150
 */


 // Definition for singly-linked list.
 // commit this class and copy code then will get accepted 
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
        val = x;
        next = null;
     }
  }

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast =fast.next.next;

            if(slow == fast)
                return true;
        }
        return false;        
    }
}

public class LinkedListCycle {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}
