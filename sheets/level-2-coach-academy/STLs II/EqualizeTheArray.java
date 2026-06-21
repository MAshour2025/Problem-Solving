/*
 * CodeForces 1490F - Equalize the Array
 *
 * Topic: STLs II
 * Difficulty: Hard
 *
 * Time Complexity: O(k²)
 * Space Complexity: O(k)
 *
 * Link:
 * https://codeforces.com/problemset/problem/1490/F
 */

import java.util.*;

public class EqualizeTheArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        Solution solution = new Solution();

        while (testCases-- > 0) {

            int arrayLength = scanner.nextInt();

            System.out.println(
                    solution.solve(scanner, arrayLength)
            );
        }

        scanner.close();
    }
}

class Solution {

    public long solve(Scanner scanner,
                      int arrayLength) {

        Map<Long, Long> frequencyMap =
                new HashMap<>();

        for (int i = 0; i < arrayLength; i++) {

            long number = scanner.nextLong();

            frequencyMap.merge(
                    number,
                    1L,
                    Long::sum
            );
        }

        Map<Long, Long> frequencyOfFrequencyMap =
                new TreeMap<>();

        for (long frequency : frequencyMap.values()) {

            frequencyOfFrequencyMap.merge(
                    frequency,
                    1L,
                    Long::sum
            );
        }

        long minimumDeletions = Long.MAX_VALUE;

        for (long targetFrequency
                : frequencyOfFrequencyMap.keySet()) {

            long undeletedValues = 0;

            for (Map.Entry<Long, Long> entry
                    : frequencyOfFrequencyMap.entrySet()) {

                long frequency = entry.getKey();
                long count = entry.getValue();

                if (frequency >= targetFrequency) {

                    undeletedValues +=
                            targetFrequency * count;
                }
            }

            minimumDeletions = Math.min(
                    minimumDeletions,
                    arrayLength - undeletedValues
            );
        }

        return minimumDeletions;
    }
}