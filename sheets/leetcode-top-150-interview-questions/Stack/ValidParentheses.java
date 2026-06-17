/*
 * LeetCode 20. Valid Parentheses
 *
 * Topic: Stack
 * Difficulty: Easy
 * *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Link:
 * https://leetcode.com/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-interview-150
 */

import java.util.*;
 

class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<s.length();i++){

            Character currentChar = s.charAt(i);
            if(currentChar =='(' || currentChar =='['|| currentChar =='{')
                stack.push(currentChar);
            else{
                if(stack.isEmpty())
                    return false;
                char ch = stack.pop();
                if( (currentChar ==')' && ch != '(') || (currentChar ==']' && ch != '[') || (currentChar =='}' && ch != '{') )
                    return false;
            }

        }
        return stack.isEmpty() ? true : false;
        
    }
}

public class ValidParentheses {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Example test
        // System.out.println(solution.exampleMethod());

    }
}
