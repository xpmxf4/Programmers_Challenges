package org.example.lv2.dfsBfs;

public class TargetNum {

    private static int answer = 0;

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));   // 5
        System.out.println(solution(new int[]{4, 1, 2, 1}, 4));     // 2
    }

    private static int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }

    private static void dfs(int start_idx, int temp, int[] numbers, int target) {

        if (start_idx == numbers.length) {
            if (temp == target) {
                answer++;
            }
            return;
        }

        int currVal = numbers[start_idx];

        dfs(start_idx + 1, temp + currVal, numbers, target);
        dfs(start_idx + 1, temp - currVal, numbers, target);
    }
}
