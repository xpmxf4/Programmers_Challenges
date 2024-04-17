package org.example.somewhere;

import java.util.*;

public class First {

    public static void main(String[] args) {

        // [1, 5, 8, 2, 10, 4, 6]
        System.out.println("solution(new int[]{1, 5, 8, 2, 10, 5, 4, 6, 4, 8}) = " + Arrays.toString(solution(new int[]{1, 5, 8, 2, 10, 5, 4, 6, 4, 8})));

        // [5, 4, 4, 3, 5]
        System.out.println("solution(new int[]{5, 4, 4, 3, 5}) = " + Arrays.toString(solution(new int[]{5, 4, 4, 3, 5})));
    }

    public static int[] solution(int[] waiting) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for (int num : waiting) {
            set.add(num);
        }

        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }

        return result;
    }
}
