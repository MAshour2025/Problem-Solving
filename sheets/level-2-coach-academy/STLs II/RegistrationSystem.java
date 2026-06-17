/*
 * CodeForces 4C - Registration System
 *
 * Topic: STLs II
 * Difficulty: Easy
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Link:
 * https://codeforces.com/problemset/problem/4/C
 */

import java.util.*;

public class RegistrationSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String[] requests = new String[n];

        for (int i = 0; i < n; i++) {
            requests[i] = scanner.next();
        }

        Solution solution = new Solution();

        List<String> result = solution.solve(requests);

        for (String response : result) {
            System.out.println(response);
        }

        scanner.close();
    }
}

class Solution {

    public List<String> solve(String[] requests) {

        Map<String, Integer> names = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String username : requests) {

            int count = names.merge(username, 1, Integer::sum);

            result.add(
                    count == 1
                            ? "OK"
                            : username + (count - 1)
            );
        }

        return result;
    }
}