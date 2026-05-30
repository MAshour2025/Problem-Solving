/*
 * LeetCode 21. MergeTwoSortedLists
 *
 * Topic: Linked List
 * Difficulty: Easy
 * *
 * Time Complexity: O(n+m)
 * Space Complexity: O(n+m)
 *
 * Link:
 * https://leetcode.com/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-interview-150
 */

// Definition for singly-linked list.
// commit ListNode class and copy code then will get accepted 
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        while (list1 != null || list2 != null) {
            int num;
            if (list1 == null && list2 != null){
                num = list2.val;
                list2 = list2.next;
            }
            
            else if (list2 == null && list1 != null){
                num = list1.val;
                list1 = list1.next;
            }

            else if(list1.val <= list2.val){
                num =list1.val;
                list1 = list1.next;
            }
            else{
                num =list2.val;
                list2 = list2.next;
            }
            current.next = new ListNode(num);
            current = current.next;
            
        }
        return dummy.next;

    }
}

public class MergeTwoSortedLists {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}
