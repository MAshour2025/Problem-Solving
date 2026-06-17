/*
 * HackerRank - Left Rotation
 *
 * Topic: STLs I
 * Difficulty: Easy
 *
 * Time Complexity: O(n + d)
 * Space Complexity: O(n)
 *
 * Link:
 * https://www.hackerrank.com/challenges/array-left-rotation
 */

import java.util.*;

public class LeftRotation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int d = scanner.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }

        Solution solution = new Solution();

        List<Integer> result = solution.solve(d, arr);

        for (int num : result) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}

class Solution {

    public List<Integer> solve(int d, List<Integer> arr) {

        Queue<Integer> queue = new LinkedList<>();

        for (int num : arr) {
            queue.offer(num);
        }

        d %= arr.size();

        for (int i = 0; i < d; i++) {
            queue.offer(queue.poll());
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}