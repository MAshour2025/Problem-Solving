/*
 * SPOJ - QUEUEEZ
 *
 * Topic: STLs I
 * Difficulty: Easy
 *
 * Time Complexity: O(q)
 * Space Complexity: O(q)
 *
 * Link:
 * https://www.spoj.com/problems/QUEUEEZ/en/
 */

import java.io.*;
import java.util.*;

public class QUEUEEZ {

    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        int queriesCount = Integer.parseInt(bufferedReader.readLine());

        Solution solution = new Solution();

        System.out.print(solution.solve(bufferedReader, queriesCount));

        bufferedReader.close();
    }
}

class Solution {

    public String solve(BufferedReader bufferedReader, int queriesCount)
            throws Exception {

        Deque<Integer> queue = new ArrayDeque<>();

        StringBuilder result = new StringBuilder();

        while (queriesCount-- > 0) {

            String[] input = bufferedReader.readLine().split(" ");

            int operationType = Integer.parseInt(input[0]);

            switch (operationType) {

                case 1:
                    int value = Integer.parseInt(input[1]);
                    queue.offerLast(value);
                    break;

                case 2:
                    if (!queue.isEmpty()) {
                        queue.pollFirst();
                    }
                    break;

                case 3:
                    if (queue.isEmpty()) {
                        result.append("Empty!\n");
                    } else {
                        result.append(queue.peekFirst()).append("\n");
                    }
                    break;
            }
        }

        return result.toString();
    }
}