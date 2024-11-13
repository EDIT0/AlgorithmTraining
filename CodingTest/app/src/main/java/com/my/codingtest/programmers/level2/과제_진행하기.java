package com.my.codingtest.programmers.level2;

import java.util.Arrays;
import java.util.Stack;

public class 과제_진행하기 {

    public static void main(String[] args) {
        String[][] plans1 = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        String[][] plans2 = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        String[][] plans3 = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};

        System.out.println(Arrays.toString(solution(plans1)));
    }

    public static String[] solution(String[][] plans) {
        String[] answer = {};

        answer = new String[plans.length];

        // 시간 오름차순으로 정렬
        Arrays.sort(plans, (o1, o2) -> {
            return o1[1].compareTo(o2[1]);
        });

        int ansIndex = 0;

        Stack<String[]> stack = new Stack<>();

        for(int i=1;i<plans.length;i++) {
            // 다음 과목 시작 전에 끝낼 수 있는지 확인, 못끝냄: 양수, 끝냄: 음수
            int remainingTime = Integer.parseInt(String.valueOf(toMinute(plans[i-1][1]))) + Integer.parseInt(plans[i-1][2]) - Integer.parseInt(String.valueOf(toMinute(plans[i][1])));
            if(remainingTime > 0) {
                plans[i-1][2] = String.valueOf(remainingTime);
                stack.push(plans[i-1]);
            } else {
                answer[ansIndex] = plans[i-1][0];
                ansIndex += 1;

                int updatedRemainingTime = 0;
                while (true) {
                    if(stack.isEmpty()) {
                        break;
                    }

                    String[] recentPlan = stack.pop();

                    // 최근 과목 - 남은 시간
                    updatedRemainingTime = Integer.parseInt(recentPlan[2]) + remainingTime;
                    remainingTime = updatedRemainingTime;
                    if(updatedRemainingTime > 0) {
                        // 0보다 크면 남은 시간 동안 최근 과목 못끝냄
                        recentPlan[2] = String.valueOf(updatedRemainingTime);
                        stack.push(recentPlan);
                        break;
                    } else {
                        // 0이거나 0보다 작으면 과목 끝냈고, 갱신된 남은 시간 a 값을 가지고 다시 계산
                        answer[ansIndex] = recentPlan[0];
                        ansIndex += 1;
                    }
                }
            }
            // 마지막 과목은 무조건 끝냄
            if(i == plans.length-1) {
                answer[ansIndex] = plans[i][0];
                ansIndex += 1;
            }
        }

        // 나머지 과목들 넣어주기
        while (!stack.isEmpty()) {
            answer[ansIndex] = stack.pop()[0];
            ansIndex += 1;
        }

        return answer;
    }

    public static long toMinute(String time) {
        String[] tmpStr = time.split(":");
        long hour = Integer.parseInt(tmpStr[0]);
        long minute = Integer.parseInt(tmpStr[1]);

        return hour*60+minute;
    }
}
