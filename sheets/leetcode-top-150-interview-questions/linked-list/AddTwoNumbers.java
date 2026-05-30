/*
 * LeetCode 2. Add Two Numbers
 *
 * Topic: Linked List
 * Difficulty: Medium
 * *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Link:
 * https://leetcode.com/problems/add-two-numbers/?envType=study-plan-v2&envId=top-interview-150
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy =new ListNode();
        ListNode current = dummy;
        int carry =0;
        while (l1!= null || l2!=null || carry !=0) {
            int digit1=0;
            int digit2=0;

            if (l1 != null)
            {
                digit1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null)
            {
                digit2 = l2.val;
                l2 = l2.next;
            }
            int sum = digit1 + digit2 + carry;

            carry = sum / 10;
            int resultNum = sum % 10;

            current.next = new ListNode(resultNum);
            current = current.next;  
            
        }
        return dummy.next;       
        
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}
