package com.my.codingtest.programmers.level2;

import java.util.PriorityQueue;

public class 우선순위_큐_더_맵게 {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        // 2

        System.out.println(solution(scoville, k));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i=0;i<scoville.length;i++) {
            pq.add((long) scoville[i]);
        }

        int count = 0;
        long s = 0;
        while (pq.size() >= 2) {
            long first = pq.poll();
            long second = pq.poll();

            if(first >= K && second >= K) {
                break;
            } else {
                s = first + (second*2);
                pq.add(s);
                count += 1;
            }
        }

        if(K <= s) {
            answer = count;
        } else {
            if(s != 0) {
                answer = -1;
            }
        }

        return answer;
    }
    
}
