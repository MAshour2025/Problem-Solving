/*
 * SPOJ - ADAQUEUE
 *
 * Topic: STLs I
 * Difficulty: Medium
 *
 * Time Complexity: O(q)
 * Space Complexity: O(q)
 *
 * Link:
 * https://www.spoj.com/problems/ADAQUEUE/en/
 */

import java.util.*;

public class ADAQUEUE {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int queriesCount = scanner.nextInt();

        Solution solution = new Solution();

        System.out.print(solution.solve(scanner, queriesCount));

        scanner.close();
    }
}

class Solution {

    public String solve(Scanner scanner, int queriesCount) {

        Deque<Integer> deque = new ArrayDeque<>();

        boolean reversed = false;

        StringBuilder result = new StringBuilder();

        while (queriesCount-- > 0) {

            String command = scanner.next();

            switch (command) {

                case "reverse":

                    reversed = !reversed;
                    break;

                case "push_back":

                    int backValue = scanner.nextInt();

                    if (!reversed) {
                        deque.addLast(backValue);
                    } else {
                        deque.addFirst(backValue);
                    }

                    break;

                case "toFront":

                    int frontValue = scanner.nextInt();

                    if (!reversed) {
                        deque.addFirst(frontValue);
                    } else {
                        deque.addLast(frontValue);
                    }

                    break;

                case "front":

                    if (deque.isEmpty()) {

                        result.append("No job for Ada?\n");

                    } else {

                        if (!reversed) {
                            result.append(deque.pollFirst()).append("\n");
                        } else {
                            result.append(deque.pollLast()).append("\n");
                        }
                    }

                    break;

                case "back":

                    if (deque.isEmpty()) {

                        result.append("No job for Ada?\n");

                    } else {

                        if (!reversed) {
                            result.append(deque.pollLast()).append("\n");
                        } else {
                            result.append(deque.pollFirst()).append("\n");
                        }
                    }

                    break;
            }
        }

        return result.toString();
    }
}