/*
 * HackerRank - Two Strings
 *
 * Topic: STLs II
 * Difficulty: Easy
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 *
 * Link:
 * https://www.hackerrank.com/contests/101hack19/challenges/two-strings/problem
 */

import java.util.*;

public class TwoStrings {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        Solution solution = new Solution();

        while (testCases-- > 0) {

            String firstString = scanner.next();
            String secondString = scanner.next();

            System.out.println(
                    solution.solve(firstString, secondString)
            );
        }

        scanner.close();
    }
}

class Solution {

    public String solve(String firstString,
                        String secondString) {

        Set<Character> characters = new HashSet<>();

        for (int i = 0; i < firstString.length(); i++) {
            characters.add(firstString.charAt(i));
        }

        for (int i = 0; i < secondString.length(); i++) {

            if (characters.contains(
                    secondString.charAt(i))) {

                return "YES";
            }
        }

        return "NO";
    }
}