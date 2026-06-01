/*
 * LeetCode 146. LRU Cache
 *
 * Topic: Linked List
 * Difficulty: Medium
 * *
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 *
 * Link:
 * https://leetcode.com/problems/lru-cache/description/?envType=study-plan-v2&envId=top-interview-150
 */

import java.util.*;

// Definition for Doubly-linked list.
class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
    public void insertAtHead(Node node, Node head){
        
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }

    public void removeNode(Node node){

            node.prev.next = node.next;
            node.next.prev = node.prev;
    }
    
}

class LRUCache {

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;

        
    }
    
    public int get(int key) {
        if(map.containsKey(key)){

            Node node = map.get(key); 
            
            node.removeNode(node);
            node.insertAtHead(node, head);

            return node.value;
        }
        else
            return -1;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){

            Node node = map.get(key);

            node.removeNode(node);
            node.insertAtHead(node, head);

            node.value = value;        

        }else{

            if (map.size() == capacity){

                Node node = tail.prev;

                node.removeNode(node);
                
                map.remove(node.key);
            }

            Node newNode = new Node(key, value);

            newNode.insertAtHead(newNode, head);                   

            map.put(key, newNode);
        }            

        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRU_Cache {
    public static void main(String[] args) {

        // test

    }
}