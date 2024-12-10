package com.my.codingtest.programmers.level2;

import java.util.*;

public class 우선순위_큐_디펜스_게임 {
    public static void main(String[] args) {
        int n1 = 7;
        int k1 = 3;
        int[] enemy1 = {4, 2, 4, 5, 3, 3, 1};
        // 5

        int n2 = 2;
        int k2 = 4;
        int[] enemy2 = {3, 3, 3, 3};
        // 4

        int n3 = 10;
        int k3 = 2;
        int[] enemy3 = {5,5,5,5,5};
        // 4

        int n4 = 10;
        int k4 = 1;
        int[] enemy4 = {5,5,5,5,5};
        // 3

        System.out.println(solution(n1, k1, enemy1));
    }

    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0;i<enemy.length;i++) {
            priorityQueue.add(enemy[i]);

            if(priorityQueue.size() > k) {
                n -= priorityQueue.poll();
            }
            if(n < 0) {
                break;
            }
            answer += 1;
        }

        return answer;
    }
}
