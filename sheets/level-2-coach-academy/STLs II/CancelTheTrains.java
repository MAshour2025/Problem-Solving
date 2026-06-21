/*
 * CodeForces 1453A - Cancel the Trains
 *
 * Topic: STLs II
 * Difficulty: Easy
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(n + m)
 *
 * Link:
 * https://codeforces.com/problemset/problem/1453/A
 */

import java.util.*;

public class CancelTheTrains {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        Solution solution = new Solution();

        while (testCases-- > 0) {
            System.out.println(solution.solve(scanner));
        }

        scanner.close();
    }
}

class Solution {

    public int solve(Scanner scanner) {

        int firstArraySize = scanner.nextInt();
        int secondArraySize = scanner.nextInt();

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int i = 0; i < firstArraySize; i++) {
            uniqueNumbers.add(scanner.nextInt());
        }

        for (int i = 0; i < secondArraySize; i++) {
            uniqueNumbers.add(scanner.nextInt());
        }

        return (firstArraySize + secondArraySize)
                - uniqueNumbers.size();
    }
}