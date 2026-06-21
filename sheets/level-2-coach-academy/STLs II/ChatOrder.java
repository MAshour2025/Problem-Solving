/*
 * CodeForces 637B - Chat Order
 *
 * Topic: STLs II
 * Difficulty: Medium
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Link:
 * https://codeforces.com/problemset/problem/637/B
 */

import java.util.*;

public class ChatOrder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int messagesCount = scanner.nextInt();

        String[] friends = new String[messagesCount];

        for (int i = 0; i < messagesCount; i++) {
            friends[i] = scanner.next();
        }

        Solution solution = new Solution();

        solution.solve(friends);

        scanner.close();
    }
}

class Solution {

    public void solve(String[] friends) {

        Set<String> visitedFriends = new HashSet<>();

        for (int i = friends.length - 1; i >= 0; i--) {

            if (visitedFriends.add(friends[i])) {
                System.out.println(friends[i]);
            }
        }
    }
}