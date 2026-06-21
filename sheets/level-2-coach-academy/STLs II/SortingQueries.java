/*
 * AtCoder ABC217 E - Sorting Queries
 *
 * Topic: STLs II
 * Difficulty: Medium
 *
 * Time Complexity: O(Q log Q)
 * Space Complexity: O(Q)
 *
 * Link:
 * https://atcoder.jp/contests/abc217/tasks/abc217_e
 */

import java.util.*;

// change name of this class to "Main" and will get accepted
public class SortingQueries {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int queriesCount = scanner.nextInt();

        Solution solution = new Solution();

        solution.solve(scanner, queriesCount);

        scanner.close();
    }
}

class Solution {

    public void solve(Scanner scanner,
                      int queriesCount) {

        Deque<Long> queue = new ArrayDeque<>();

        PriorityQueue<Long> sortedNumbers =
                new PriorityQueue<>();

        while (queriesCount-- > 0) {

            int queryType = scanner.nextInt();

            switch (queryType) {

                case 1:

                    long value = scanner.nextLong();

                    queue.offer(value);

                    break;

                case 2:

                    if (!sortedNumbers.isEmpty()) {

                        System.out.println(
                                sortedNumbers.poll()
                        );

                    } else {

                        System.out.println(
                                queue.poll()
                        );
                    }

                    break;

                case 3:

                    while (!queue.isEmpty()) {

                        sortedNumbers.offer(
                                queue.poll()
                        );
                    }

                    break;
            }
        }
    }
}