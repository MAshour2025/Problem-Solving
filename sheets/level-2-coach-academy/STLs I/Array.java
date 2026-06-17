/*
 * CodeForces 300A - Array
 *
 * Topic: STLs I
 * Difficulty: Medium
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Link:
 * https://codeforces.com/problemset/problem/300/A
 */

import java.util.*;

public class Array {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        long[] numbers = new long[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextLong();
        }

        Solution solution = new Solution();

        solution.solve(numbers);

        scanner.close();
    }
}

class Solution {

    public void solve(long[] numbers) {

        List<Long> negativeNumbers = new ArrayList<>();
        List<Long> positiveNumbers = new ArrayList<>();
        List<Long> zeroNumbers = new ArrayList<>();

        for (long number : numbers) {

            if (number < 0) {
                negativeNumbers.add(number);
            } else if (number > 0) {
                positiveNumbers.add(number);
            } else {
                zeroNumbers.add(number);
            }
        }

        if (positiveNumbers.isEmpty()) {

            positiveNumbers.add(
                    negativeNumbers.remove(negativeNumbers.size() - 1));

            positiveNumbers.add(
                    negativeNumbers.remove(negativeNumbers.size() - 1));
        }

        if (negativeNumbers.size() % 2 == 0) {

            zeroNumbers.add(
                    negativeNumbers.remove(negativeNumbers.size() - 1));
        }

        printGroup(negativeNumbers);
        printGroup(positiveNumbers);
        printGroup(zeroNumbers);
    }

    private void printGroup(List<Long> group) {

        System.out.print(group.size());

        for (long item : group) {
            System.out.print(" " + item);
        }

        System.out.println();
    }
}