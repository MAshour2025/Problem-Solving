/*
 * LeetCode 92. Reverse Linked List II
 *
 * Topic: Linked List
 * Difficulty: Medium
 * *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Link:
 * https://leetcode.com/problems/reverse-linked-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */

import java.util.*;

// Definition for singly-linked list.
// commit this class and copy code then will get accepted 
// class ListNode {
//       int val;
//       ListNode next;
//       ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
 

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // Store values of the required range in reverse order
        Deque<Integer> stack = new ArrayDeque<>();

        ListNode current = head;
        int i = 1;

        boolean flag = false;
        ListNode leftNode = null;

        while (current != null) {

            // Reached the start of the range
            if (i == left) {
                flag = true;
                leftNode = current;
            }

            // No need to continue after right position
            if (i > right)
                break;

            // Push values between left and right
            if (flag)
                stack.push(current.val);

            current = current.next;
            i++;
        }

        // Rewrite values using the reversed order from the stack
        current = leftNode;

        while (!stack.isEmpty()) {

            current.val = stack.pop();
            current = current.next;
        }

        return head;
    }
}
public class ReverseLinkedListII {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}
