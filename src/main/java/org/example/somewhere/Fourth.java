package org.example.somewhere;

import java.util.*;

public class Fourth {


    public static int solution(int[][] cars) {
        int n = cars.length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Find the locations of the car and the exit
        int carX = 0, carY = 0, exitX = 0, exitY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cars[i][j] == 1) {
                    carX = i;
                    carY = j;
                } else if (cars[i][j] == 4) {
                    exitX = i;
                    exitY = j;
                }
            }
        }

        // Use BFS to find the minimum number of red cars that must be moved
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.redCount));
        pq.add(new Node(carX, carY, 0));
        boolean[][] visited = new boolean[n][n];
        visited[carX][carY] = true;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int x = current.x;
            int y = current.y;
            int redCount = current.redCount;

            if (x == exitX && y == exitY) {
                return redCount;
            }

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (cars[nx][ny] == 3) { // Unrepairable black car
                        continue;
                    } else if (cars[nx][ny] == 2) { // Repairable red car
                        pq.add(new Node(nx, ny, redCount + 1));
                    } else { // Empty space or exit
                        pq.add(new Node(nx, ny, redCount));
                    }
                }
            }
        }

        return -1; // If no path is found
    }

    static class Node {
        int x, y, redCount;

        Node(int x, int y, int redCount) {
            this.x = x;
            this.y = y;
            this.redCount = redCount;
        }
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        int[][] cars1 = {{0, 0, 3, 0, 0, 0, 0}, {1, 0, 3, 0, 0, 0, 0}, {0, 0, 3, 0, 0, 0, 0}, {0, 0, 2, 0, 0, 3, 3}, {2, 2, 2, 0, 2, 0, 0}, {3, 3, 2, 0, 2, 0, 3}, {3, 3, 2, 0, 2, 0, 4}};
        System.out.println("Test Case 1 Result: " + solution(cars1)); // 예상 출력: 2

        // 테스트 케이스 2
        int[][] cars2 = {{0, 2, 0, 0, 0}, {0, 4, 2, 0, 0}, {0, 2, 0, 0, 0}, {0, 0, 0, 2, 1}, {0, 0, 0, 2, 0}};
        System.out.println("Test Case 2 Result: " + solution(cars2)); // 예상 출력: 0

        // 테스트 케이스 3
        int[][] cars3 = {{0, 0, 0, 0, 0}, {3, 0, 0, 0, 0}, {4, 3, 0, 0, 0}, {0, 0, 3, 0, 0}, {0, 0, 0, 3, 1}};
        System.out.println("Test Case 3 Result: " + solution(cars3)); // 예상 출력: -1
    }
}
