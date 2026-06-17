/*
 * CodeForces 1005A - Tanya and Stairways
 *
 * Topic: STLs I
 * Difficulty: Easy
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Link:
 * https://codeforces.com/problemset/problem/1005/A
 */

import java.util.*;

public class TanyaAndStairways {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numbersCount = scanner.nextInt();

        Solution solution = new Solution();

        solution.solve(scanner, numbersCount);

        scanner.close();
    }
}

class Solution {

    public void solve(Scanner scanner, int numbersCount) {

        int previousNumber = 0;
        int currentNumber = 0;

        List<Integer> stairways = new ArrayList<>();

        while (numbersCount-- > 0) {

            currentNumber = scanner.nextInt();

            if (currentNumber <= previousNumber) {
                stairways.add(previousNumber);
            }

            previousNumber = currentNumber;
        }

        stairways.add(currentNumber);

        System.out.println(stairways.size());

        for (int stairwayLength : stairways) {
            System.out.print(stairwayLength + " ");
        }
    }
}