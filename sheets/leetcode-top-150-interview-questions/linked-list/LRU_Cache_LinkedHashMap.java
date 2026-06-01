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
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        cache = new LinkedHashMap<>(capacity, 0.75f, true) {

            @Override
            protected boolean removeEldestEntry(
                    Map.Entry<Integer, Integer> eldest) {

                return size() > LRUCache.this.capacity;
            }
        };
    }

    public int get(int key) {

        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {

        cache.put(key, value);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRU_Cache_LinkedHashMap {
    public static void main(String[] args) {

        // test

    }
}