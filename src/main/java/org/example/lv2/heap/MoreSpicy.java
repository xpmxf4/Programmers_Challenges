package org.example.lv2.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MoreSpicy {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));     // 2
    }

    public static int solution(int[] scoville, int K) {

        int cnt = 0;

        Queue<Integer> pq = new PriorityQueue<>();

        for(int i : scoville) {
            pq.add(i);
        }
        if(checkPqElSize(pq, K)) return 0;

        boolean flag = false;
        while(pq.size() != 1) {
            cnt++;

            int least = pq.poll();
            int secLeast = pq.poll();

            int mixedScoville = least + secLeast * 2;
            pq.add(mixedScoville);

            if(checkPqElSize(pq, K)) {
                flag = true;
                break;
            }
        }

        if(!flag) return -1;
        return cnt;
    }

    private static boolean checkPqElSize(Queue<Integer> pq, int K) {
        boolean flag = true;

        for(int i : pq) {
            if(i < K) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
