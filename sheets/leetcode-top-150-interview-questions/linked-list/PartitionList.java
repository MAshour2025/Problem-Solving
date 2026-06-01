/*
 * LeetCode 86. Partition List
 *
 * Topic: Linked List
 * Difficulty: Medium
 * *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Link:
 * https://leetcode.com/problems/partition-list/description/?envType=study-plan-v2&envId=top-interview-150
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
    public ListNode partition(ListNode head, int x) {            
        if (head==null)
            return head;

        ListNode Portion1Dummy = new ListNode();
        ListNode Portion2Dummy = new ListNode();

        ListNode current = head;
        ListNode tailPortion1 = Portion1Dummy;
        ListNode tailPortion2 = Portion2Dummy;
        while (current != null) {
            
            if(current.val < x){

                tailPortion1.next = new ListNode(current.val);                
                tailPortion1 = tailPortion1.next;
            }

            else{

                tailPortion2.next = new ListNode(current.val);
                tailPortion2 = tailPortion2.next;
            }


            current = current.next;
        }

        if(Portion1Dummy.next == null)
            return Portion2Dummy.next;
        
        else if(Portion2Dummy.next == null)
            return Portion1Dummy.next;
        else
            tailPortion1.next=Portion2Dummy.next;

        return Portion1Dummy.next;
    }
}

public class PartitionList {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}