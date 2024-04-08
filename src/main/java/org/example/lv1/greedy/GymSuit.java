package org.example.lv1.greedy;

import java.util.Arrays;

public class GymSuit {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(solution(3, new int[]{3}, new int[]{1}));
        System.out.println(solution(30, new int[]{28, 30}, new int[]{27, 29}));
        System.out.println(solution(4, new int[]{2, 4}, new int[]{3, 4})); // 3
    }

    private static int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 1];

        Arrays.fill(students, 1);

        for (int l : lost) students[l]--;
        for (int r : reserve) students[r]++;

        for (int i = 0; i < n; i++) {

            if (students[i] == 0) {

                if (i > 1 && students[i - 1] > 1) {
                    students[i]++;
                    students[i - 1]--;
                } else if (i < n && students[i + 1] > 1) {
                    students[i]++;
                    students[i + 1]--;
                }

            }
        }

        // counting
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] > 0) answer++;
        }
        return answer;
    }
}
