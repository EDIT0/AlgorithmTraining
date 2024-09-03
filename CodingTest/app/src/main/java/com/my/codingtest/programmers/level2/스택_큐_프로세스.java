package com.my.codingtest.programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class 스택_큐_프로세스 {

    public static void main(String[] args) {
        int[] priorities1 = {2, 1, 3, 2};
        int location1 = 2;
        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;


        System.out.println(solution(priorities2, location2) + "");
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순으로 정렬되서 나옴

        for(int i=0;i<priorities.length;i++) {
            queue.add(priorities[i]);
        }

        // priorities 배열 기준으로 location번째 숫자가 몇 순위로 나오는지?

        while (!queue.isEmpty()) {
            for(int i=0;i<priorities.length;i++) {
                if(queue.peek() == priorities[i]) {
                    queue.poll();
                    answer += 1;
                    if(location == i) {
                        return answer;
                    }
                }
            }
        }

        return answer;
    }

}
