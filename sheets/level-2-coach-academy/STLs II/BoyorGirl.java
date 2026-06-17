/*
 * CodeForces 236A - Boy or Girl
 *
 * Topic: STLs II
 * Difficulty: Easy
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Link:
 * https://codeforces.com/problemset/problem/236/A
 */

import java.util.*;

public class BoyorGirl {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String username = scanner.next();

        Solution solution = new Solution();

        System.out.println(solution.solve(username));

        scanner.close();
    }
}

class Solution {

    public String solve(String username) {

        Set<Character> uniqueCharacters = new HashSet<>();

        for (int i = 0; i < username.length(); i++) {
            uniqueCharacters.add(username.charAt(i));
        }

        return uniqueCharacters.size() % 2 == 0
                ? "CHAT WITH HER!"
                : "IGNORE HIM!";
    }
}

