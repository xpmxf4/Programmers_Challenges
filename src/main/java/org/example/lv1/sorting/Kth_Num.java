package org.example.lv1.sorting;

import java.util.Arrays;

public class Kth_Num {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(solution(array, commands)));
    }

    private static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for (int l = 0; l < commands.length; l++) {
            int[] command = commands[l];
            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] slicedArr = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(slicedArr);

            answer[l] = slicedArr[k - 1];
        }

        return answer;
    }
}
