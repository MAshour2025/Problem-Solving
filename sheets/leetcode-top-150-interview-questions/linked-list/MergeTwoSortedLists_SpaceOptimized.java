/*
 * LeetCode 21. MergeTwoSortedLists
 *
 * Topic: Linked List
 * Difficulty: Easy
 * *
 * Time Complexity: O(n+m)
 * Space Complexity: O(1)
 *
 * Link:
 * https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-interview-150
 */

// Definition for singly-linked list.
// commit ListNode class and copy code then will get accepted 
// class ListNode {
//       int val;
//       ListNode next;
//       ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
 

class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();

        ListNode current = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {

                current.next = list1;

                list1 = list1.next;

            } else {

                current.next = list2;

                list2 = list2.next;
            }

            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }
}

public class MergeTwoSortedLists_SpaceOptimized {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}
