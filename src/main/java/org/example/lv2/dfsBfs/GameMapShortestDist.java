package org.example.lv2.dfsBfs;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDist {
    public static int answer = -1;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{-0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] testCase1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int[][] testCase2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };

//        System.out.println(solution(testCase1));        // 11
        System.out.println(solution(testCase2));        // -1
    }

    private static int solution(int[][] maps) {
        int n = maps.length - 1;
        int m = maps[0].length - 1;
        boolean[][] visited = new boolean[n + 1][m + 1];
        visited[0][0] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        q.add(1);

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            int dist = q.poll();

            System.out.printf("(x, y) = (%d, %d)\n", x, y);

            // 도달한 경우
            if (x == n && y == m) {
                answer = dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 못 가는 경우
                if (nx < 0 || nx > n || ny < 0 || ny > m) continue;
                if (maps[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;

                q.add(nx);
                q.add(ny);
                q.add(dist + 1);
                visited[nx][ny] = true;
            }
        }

        return answer;
    }

}
