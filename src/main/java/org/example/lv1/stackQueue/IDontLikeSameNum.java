package org.example.lv1.stackQueue;

import java.util.*;

public class IDontLikeSameNum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 4, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(new int[]{1,1,3,3,0,1,1,})));
    }

    private static int[] solution(int[] arr) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            Integer val = q.poll();

            if (i == 0) {
                list.add(val);
                continue;
            }

            if (Objects.equals(list.get(list.size() - 1), val))
                continue;

            list.add(val);
        }

        int cnt = 0;
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[cnt++] = list.get(i);
        }
        return answer;
    }
}
