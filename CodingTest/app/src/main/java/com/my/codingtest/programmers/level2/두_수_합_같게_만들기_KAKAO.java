package com.my.codingtest.programmers.level2;

import java.util.*;

public class 두_수_합_같게_만들기_KAKAO {

    public static void main(String[] args) {
        int[] queue1_1 = {3, 2, 7, 2};
        int[] queue2_1 = {4, 6, 5, 1};
        // 2

        int[] queue1_2 = {1, 2, 1, 2};
        int[] queue2_2 = {1, 10, 1, 2};
        // 7

        int[] queue1_3 = {1, 1};
        int[] queue2_3 = {1, 5};
        // -1

        int[] queue1_4 = {2, 3};
        int[] queue2_4 = {2, 5};
        // -1

        System.out.println(solution(queue1_4, queue2_4));
    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long q1Sum = 0;
        long q2Sum = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=0;i<queue1.length;i++) {
            q1.add(queue1[i]);
            q1Sum += queue1[i];
        }

        for(int i=0;i<queue2.length;i++) {
            q2.add(queue2[i]);
            q2Sum += queue2[i];
        }

        long limit = (queue1.length + queue2.length) * 2;
        long limitCount = 0;

        while (true) {
            limitCount += 1;

            if(q1Sum == q2Sum) {
                break;
            } else if(q1.isEmpty() || q2.isEmpty()) {
                answer = -1;
                break;
            } else if(q1Sum > q2Sum) {
                int n = q1.poll();
                q2.add(n);
                q2Sum += n;
                q1Sum -= n;
                answer += 1;
            } else if(q1Sum < q2Sum){
                int n = q2.poll();
                q1.add(n);
                q1Sum += n;
                q2Sum -= n;
                answer += 1;
            }

            if(limit <= limitCount) {
                answer = -1;
                break;
            }
        }

        return answer;
    }

}
