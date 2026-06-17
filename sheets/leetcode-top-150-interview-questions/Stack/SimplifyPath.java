/*
 * LeetCode 71. Simplify Path
 *
 * Topic: Stack
 * Difficulty: Medium
 * *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Link:
 * https://leetcode.com/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
 */

import java.util.*;
 
class MutableInt {
    public int value;

    MutableInt(int value) {
        this.value = value;
    }
}

class Solution {

    // Handle "." and ".." directories
    public void handleDot(Deque<Character> stack, MutableInt dotCount, Character currentChar) {

        if (dotCount.value == 1) { // Current directory (.)
            while (stack.peek() != '/')
                stack.pop();

        } else if (dotCount.value == 2) { // Parent directory (..)

            while (stack.peek() != '/')
                stack.pop();

            if (stack.size() != 1) {

                stack.pop(); // Remove current '/'
                while (stack.peek() != '/')
                    stack.pop(); // Remove previous directory
            }
        } else { // Normal directory name containing dots
            if (currentChar != null)
                stack.push(currentChar);
        }

        dotCount.value = 0;
    }

    public String simplifyPath(String path) {

        Deque<Character> stack = new ArrayDeque<>();

        // Start with root '/'
        stack.push(path.charAt(0));

        MutableInt dotCount = new MutableInt(0);

        for (int i = 1; i < path.length(); i++) {

            Character currentChar = path.charAt(i);

            if (currentChar == '.') {

                // Count consecutive dots
                if (stack.peek() == '/' || dotCount.value > 0)
                    dotCount.value++;

                stack.push(currentChar);

            } else if (currentChar == '/') {

                // Process "." or ".."
                if (stack.peek() == '.') {

                    handleDot(stack, dotCount, currentChar);

                } else if (stack.peek() != '/')
                    stack.push(currentChar); // Avoid duplicate '/'

            } else {

                // Reset dot counter for normal characters
                if (stack.peek() == '.')
                    dotCount.value = 0;

                stack.push(currentChar);
            }
        }

        // Handle path ending with dots
        if (dotCount.value > 0)
            handleDot(stack, dotCount, null);

        // Remove trailing '/'
        if (stack.peek() == '/' && stack.size() != 1)
            stack.pop();

        // Build final path
        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty())
            result.append(stack.pollLast());

        return result.toString();
    }
}

public class SimplifyPath {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));

    }
}