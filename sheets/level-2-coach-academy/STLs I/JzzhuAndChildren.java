/*
 * CodeForces 450A - Jzzhu and Children
 *
 * Topic: STLs I
 * Difficulty: Easy
 *
 * Time Complexity: O(n + k)
 * Space Complexity: O(n)
 *
 * Link:
 * https://codeforces.com/problemset/problem/450/A
 */

import java.util.*;

public class JzzhuAndChildren {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int childrenCount = scanner.nextInt();
        int candiesPerTurn = scanner.nextInt();

        int[] candies = new int[childrenCount];

        for (int i = 0; i < childrenCount; i++) {
            candies[i] = scanner.nextInt();
        }

        Solution solution = new Solution();

        System.out.println(
                solution.solve(childrenCount, candiesPerTurn, candies));

        scanner.close();
    }
}

class Solution {

    public int solve(int childrenCount,
                     int candiesPerTurn,
                     int[] candies) {

        Deque<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();

        for (int i = 0; i < childrenCount; i++) {

            queue.offer(
                    new AbstractMap.SimpleEntry<>(
                            i + 1,
                            candies[i]
                    )
            );
        }

        while (queue.size() > 1) {

            Map.Entry<Integer, Integer> child = queue.poll();

            if (child.getValue() > candiesPerTurn) {

                child.setValue(
                        child.getValue() - candiesPerTurn
                );

                queue.offer(child);
            }
        }

        return queue.peek().getKey();
    }
}