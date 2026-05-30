/*
 * LeetCode 138. Copy List with Random Pointer
 *
 * Topic: Linked List
 * Difficulty: Medium
 * *
 * Time Complexity: O(n^2)
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

        // Create a deep copy of the list without random pointers
        Node dummy = new Node(-1);
        Node listCopyCurrent = dummy;
        Node listCurrent = head;

        while (listCurrent != null) {

            // Copy current node value
            listCopyCurrent.next = new Node(listCurrent.val);
            listCopyCurrent = listCopyCurrent.next;

            listCurrent = listCurrent.next;
        }

        // Traverse original and copied lists together
        listCurrent = head;
        listCopyCurrent = dummy.next;

        while (listCurrent != null) {

            Node listCurrentRandom = listCurrent.random;
            Node listCopyCurrentRandom;

            if (listCurrentRandom == null) {

                // Random pointer is null
                listCopyCurrentRandom = null;

            } else {

                // Find the index of the random node
                Node listCurrentCurrent = head;
                int index = 0;

                while (listCurrentCurrent != null) {

                    if (listCurrentCurrent == listCurrentRandom)
                        break;

                    index++;
                    listCurrentCurrent = listCurrentCurrent.next;
                }

                // Move to the same index in the copied list
                listCopyCurrentRandom = dummy.next;

                while (index > 0) {

                    listCopyCurrentRandom = listCopyCurrentRandom.next;
                    index--;
                }
            }

            // Connect copied random pointer
            listCopyCurrent.random = listCopyCurrentRandom;

            listCurrent = listCurrent.next;
            listCopyCurrent = listCopyCurrent.next;
        }

        return dummy.next;
    }
}
public class CopyListwithRandomPointer {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}
