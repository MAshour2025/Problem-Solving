/*
 * HackerRank - Balanced Brackets
 *
 * Topic: STLs I
 * Difficulty: Easy
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Link:
 * https://www.hackerrank.com/contests/master/challenges/balanced-brackets/problem
 */

import java.util.*;

public class BalancedBrackets {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        Solution solution = new Solution();

        while (testCases-- > 0) {

            String brackets = scanner.next();

            System.out.println(solution.solve(brackets));
        }

        scanner.close();
    }
}

class Solution {

    public String solve(String brackets) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char currentBracket : brackets.toCharArray()) {

            if (currentBracket == '('
                    || currentBracket == '{'
                    || currentBracket == '[') {

                stack.push(currentBracket);
            } else {

                if (stack.isEmpty()) {
                    return "NO";
                }

                char topBracket = stack.pop();

                if ((currentBracket == ')' && topBracket != '(')
                        || (currentBracket == '}' && topBracket != '{')
                        || (currentBracket == ']' && topBracket != '[')) {

                    return "NO";
                }
            }
        }

        return stack.isEmpty()
                ? "YES"
                : "NO";
    }
}