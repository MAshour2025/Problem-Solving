/*
 * HackerRank - Simple Text Editor
 *
 * Topic: STLs I
 * Difficulty: Medium
 *
 * Time Complexity: O(q * n)
 * Space Complexity: O(q * n)
 *
 * Link:
 * https://www.hackerrank.com/contests/master/challenges/simple-text-editor/problem
 */

import java.util.*;

public class SimpleTextEditor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int operationsCount = scanner.nextInt();

        Solution solution = new Solution();

        solution.solve(scanner, operationsCount);

        scanner.close();
    }
}

class Solution {

    public void solve(Scanner scanner, int operationsCount) {

        StringBuilder text = new StringBuilder();

        Deque<String> history = new ArrayDeque<>();

        while (operationsCount-- > 0) {

            int operationType = scanner.nextInt();

            switch (operationType) {

                case 1:

                    history.push(text.toString());

                    String appendedText = scanner.next();

                    text.append(appendedText);

                    break;

                case 2:

                    history.push(text.toString());

                    int charactersToDelete = scanner.nextInt();

                    text.delete(
                            text.length() - charactersToDelete,
                            text.length()
                    );

                    break;

                case 3:

                    int position = scanner.nextInt();

                    System.out.println(
                            text.charAt(position - 1)
                    );

                    break;

                case 4:

                    text = new StringBuilder(history.pop());

                    break;
            }
        }
    }
}