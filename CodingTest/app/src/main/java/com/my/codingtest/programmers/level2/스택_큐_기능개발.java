package com.my.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 스택_큐_기능개발 {

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55}; // 93, 30, 55 // 95, 90, 99, 99, 80, 99
        int[] speeds = {1, 30, 5}; // 1, 30, 5 // 1, 1, 1, 1, 1, 1

        // 2, 1
        // 1, 3, 2
        System.out.println(Arrays.toString(solution(progresses, speeds)) + "");
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;

        // 7, 3, 9
        // 5, 10, 1, 1, 20, 1
        ArrayList<Integer> remainingList = new ArrayList<>();
        for(int i=0;i<progresses.length;i++) {
            int remainingPercent = 100 - progresses[i];
            int remainDays = remainingPercent / speeds[i];
            int tmp = remainingPercent % speeds[i];
            if(tmp != 0) {
                remainDays += 1;
            }

            remainingList.add(remainDays);
        }

        Queue<Integer> queue = new LinkedList<>();

        ArrayList<Integer> resultList = new ArrayList<>();
        int count = 1;
        for(int i=0;i<remainingList.size();i++) {
            if(queue.isEmpty()) { // 큐가 비어있으면 추가
                queue.add(remainingList.get(i));
            } else {
                System.out.println(queue.peek()+"/"+remainingList.get(i));
                if(queue.peek() < remainingList.get(i)) { // 큐의 맨 앞의 숫자보다 현재 숫자가 크면 배포 가능
                    for(int j=0;j<count;j++) { // 지금까지 올렸던 count 만큼 poll()
                        queue.poll();
                    }
                    resultList.add(count); // count 저장
                    count = 1; // count 1로 초기화
                    queue.add(remainingList.get(i)); // 현재 숫자를 큐에 넣어준다.
                } else {
                    count++; // 큐의 맨 앞의 숫자보다 현재 숫자가 작거나 같으면 배포 불가능, count+1
                    queue.add(remainingList.get(i)); // 큐에 추가
                }
            }

            if(remainingList.size()-1 == i) {
                resultList.add(count);
            }
        }

        answer = resultList.stream().mapToInt(Integer::intValue).toArray();


        return answer;
    }

}
