/*
 * CodeForces 443A - Anton and Letters
 *
 * Topic: STLs II
 * Difficulty: Easy
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Link:
 * https://codeforces.com/problemset/problem/443/A
 */

import java.util.*;

public class AntonAndLetters {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Solution solution = new Solution();

        System.out.println(solution.solve(input));

        scanner.close();
    }
}

class Solution {

    public int solve(String input) {

        Set<Character> uniqueLetters = new HashSet<>();

        for (char currentCharacter : input.toCharArray()) {

            if (currentCharacter >= 'a'
                    && currentCharacter <= 'z') {

                uniqueLetters.add(currentCharacter);
            }
        }

        return uniqueLetters.size();
    }
}