package org.example.lv1.brute_force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockExam {
    private static int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public static void main(String[] args) {
        int[] case1 = new int[]{1, 2, 3, 4, 5};
        int[] case2 = new int[]{1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(solution(case1)));
        System.out.println(Arrays.toString(solution(case2)));

    }

    private static int[] solution(int[] answers) {
        int[] hits = new int[3];

        for (int i = 0; i < hits.length; i++) {

            for (int j = 0; j < answers.length; j++) {

                if (patterns[i][j % patterns[i].length] == answers[j]) {
                    hits[i]++;
                }
            }
        }

        int max = Math.max(hits[0], Math.max(hits[1], hits[2]));

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < hits.length; i++) {
            if (hits[i] == max)
                list.add(i + 1);
        }

        int[] answer = new int[list.size()];
        int cnt = 0;
        for (int num : list)
            answer[cnt++] = num;

        return answer;
    }
}
