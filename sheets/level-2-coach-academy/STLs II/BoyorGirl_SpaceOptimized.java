/*
 * CodeForces 236A - Boy or Girl
 *
 * Topic: STLs II
 * Difficulty: Easy
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Link:
 * https://codeforces.com/problemset/problem/236/A
 */

import java.util.*;

//change name of this class to Main for getting accepted
public class BoyorGirl_SpaceOptimized {

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

        boolean[] seen = new boolean[26];
        int distinctCount = 0;

        for (int i = 0; i < username.length(); i++) {

            int index = username.charAt(i) - 'a';

            if (!seen[index]) {
                seen[index] = true;
                distinctCount++;
            }
        }

        return distinctCount % 2 == 0
                ? "CHAT WITH HER!"
                : "IGNORE HIM!";
    }
}