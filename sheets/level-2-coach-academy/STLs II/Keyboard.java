/*
 * CodeForces 474A - Keyboard
 *
 * Topic: STLs II
 * Difficulty: Easy
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Link:
 * https://codeforces.com/problemset/problem/474/A
 */

import java.util.*;

public class Keyboard {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char direction = scanner.next().charAt(0);

        String typedMessage = scanner.next();

        Solution solution = new Solution();

        System.out.println(
                solution.solve(direction, typedMessage)
        );

        scanner.close();
    }
}

class Solution {

    public String solve(char direction, String typedMessage) {

        String keyboard =
                "qwertyuiopasdfghjkl;zxcvbnm,./";

        Map<Character, Character> keyboardMap =
                new HashMap<>();

        if (direction == 'R') {

            for (int i = 1; i < keyboard.length(); i++) {

                keyboardMap.put(
                        keyboard.charAt(i),
                        keyboard.charAt(i - 1)
                );
            }

        } else {

            for (int i = 0; i < keyboard.length() - 1; i++) {

                keyboardMap.put(
                        keyboard.charAt(i),
                        keyboard.charAt(i + 1)
                );
            }
        }

        StringBuilder originalMessage =
                new StringBuilder();

        for (int i = 0; i < typedMessage.length(); i++) {

            originalMessage.append(
                    keyboardMap.get(
                            typedMessage.charAt(i)
                    )
            );
        }

        return originalMessage.toString();
    }
}