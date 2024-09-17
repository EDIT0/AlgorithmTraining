package com.my.codingtest.programmers.level1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 명예의_전당_1 {

    public static void main(String[] args) {
        int k1 = 3;
        int[] score1 = { 10, 100, 20, 150, 1, 100, 200 };

        int k2 = 4;
        int[] score2 = { 0, 300, 40, 300, 20, 70, 150, 50, 500, 1000 };

        System.out.println(Arrays.toString(solution(k1, score1)) + "");
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = {};

        answer = new int[score.length];

        // 우선순위 큐 이용
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 내림차순으로 정렬되서 나옴

        int result = 0;

        for(int i=0;i<score.length;i++) {
            if(i < k) {
                queue.add(score[i]);
                result = queue.peek();
            } else {
                if(queue.peek() < score[i]) {
                    queue.add(score[i]);
                    queue.poll();
                }
                result = queue.peek();
            }
            answer[i] = result;
        }

        // 배열
//        int[] rank = new int[k];
//        int result = Integer.MAX_VALUE;
//
//        for(int i=0;i<score.length;i++) {
//            if(i < k) {
//                rank[i] = score[i];
//                if(result > rank[i]) {
//                    result = rank[i];
//                }
//            } else {
//                Arrays.sort(rank);
//                if(rank[0] < score[i]) {
//                    rank[0] = score[i];
//                    Arrays.sort(rank);
//                    result = rank[0];
//                }
//            }
//            answer[i] = result;
//        }

        return answer;
    }

}
