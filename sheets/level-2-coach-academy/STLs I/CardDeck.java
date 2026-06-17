/*
 * CodeForces 1492B - Card Deck
 *
 * Topic: STLs I
 * Difficulty: Medium
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Link:
 * https://codeforces.com/problemset/problem/1492/B
 */

import java.util.*;

public class CardDeck {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        Solution solution = new Solution();

        solution.solve(scanner, testCases);

        scanner.close();
    }
}

class Solution {

    public void solve(Scanner scanner, int testCases) {

        while (testCases-- > 0) {

            int deckSize = scanner.nextInt();

            List<Integer> deck = new ArrayList<>();
            List<Integer> currentSegment = new ArrayList<>();
            List<Integer> answer = new ArrayList<>();

            int[] positions = new int[deckSize + 1];

            for (int i = 0; i < deckSize; i++) {

                int card = scanner.nextInt();

                deck.add(card);
                positions[card] = i;
            }

            int currentMaximum = deck.size();

            while (!deck.isEmpty()) {

                while (true) {

                    int card = deck.get(deck.size() - 1);

                    deck.remove(deck.size() - 1);

                    currentSegment.add(card);

                    if (card == currentMaximum) {

                        for (int i = currentSegment.size() - 1; i >= 0; i--) {
                            answer.add(currentSegment.get(i));
                        }

                        while (currentMaximum >= 1
                                && positions[currentMaximum]
                                        > deck.size() - 1) {

                            currentMaximum--;
                        }

                        currentSegment.clear();

                        break;
                    }
                }
            }

            for (int card : answer) {
                System.out.print(card + " ");
            }

            System.out.println();
        }
    }
}