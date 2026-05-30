/*
 * LeetCode 138. Copy List with Random Pointer
 *
 * Topic: Linked List
 * Difficulty: Medium
 * *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Link:
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-interview-150
 */

import java.util.*;

// Definition for singly-linked list.
// commit this class and copy code then will get accepted 
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
 

class Solution {

    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        // Step 1: Insert copied nodes
        Node current = head;

        while (current != null) {

            Node copy = new Node(current.val);

            copy.next = current.next;
            current.next = copy;

            current = copy.next;
        }

        // Step 2: Set random pointers
        current = head;

        while (current != null) {

            if (current.random != null)
                current.next.random = current.random.next;

            current = current.next.next;
        }

        // Step 3: Separate the two lists
        Node dummy = new Node(-1);
        Node copyCurrent = dummy;

        current = head;

        while (current != null) {

            Node copy = current.next;

            current.next = copy.next;

            copyCurrent.next = copy;
            copyCurrent = copy;

            current = current.next;
        }

        return dummy.next;
    }
}
public class CopyListwithRandomPointer_TimeOptimized {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}
