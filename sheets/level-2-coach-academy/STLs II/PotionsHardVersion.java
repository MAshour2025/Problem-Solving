/*
 * CodeForces 1526C2 - Potions (Hard Version)
 *
 * Topic: STLs II
 * Difficulty: Hard
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 *
 * Link:
 * https://codeforces.com/problemset/problem/1526/C2
 */

import java.util.*;

public class PotionsHardVersion {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int potionsCount = scanner.nextInt();

        Solution solution = new Solution();

        System.out.println(
                solution.solve(scanner, potionsCount)
        );

        scanner.close();
    }
}

class Solution {

    public int solve(Scanner scanner,
                     int potionsCount) {

        long currentHealth = 0;

        PriorityQueue<Long> negativePotions =
                new PriorityQueue<>();

        int drunkPotionsCount = 0;

        while (potionsCount-- > 0) {

            long potion = scanner.nextLong();

            currentHealth += potion;
            drunkPotionsCount++;

            if (potion < 0) {
                negativePotions.offer(potion);
            }

            if (currentHealth < 0) {

                long worstPotion =
                        negativePotions.poll();

                currentHealth -= worstPotion;

                drunkPotionsCount--;
            }
        }

        return drunkPotionsCount;
    }
}