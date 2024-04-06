package org.example.lv1.brute_force;

import java.util.Arrays;

public class MinimumRectangle {
    private static int W_MAX = Integer.MIN_VALUE;
    private static int H_MAX = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[][] case1 = new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println(solution(case1));
    }

    public static int solution(int[][] sizes) {

        for (int[] size : sizes) {
            Arrays.sort(size);

            if (size[0] > W_MAX)
                W_MAX = size[0];

            if (size[1] > H_MAX)
                H_MAX = size[1];
        }

        return W_MAX * H_MAX;
    }
}
