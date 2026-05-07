package com.my.codingtest.programmers.level1;

public class 유연근무제_코드챌린지 {

    public static void main(String[] args) {
        // 예제 1
        int[] schedules1 = {700, 800, 1100};
        int[][] timelogs1 = {
                {710, 2359, 1050, 700, 650, 631, 659},
                {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}
        };
        int startday1 = 5;
        System.out.println(solution(schedules1, timelogs1, startday1)); // 3

        // 예제 2
        int[] schedules2 = {730, 855, 700, 720};
        int[][] timelogs2 = {
                {710, 700, 650, 735, 700, 931, 912},
                {908, 901, 805, 815, 800, 831, 835},
                {705, 701, 702, 705, 710, 710, 711},
                {707, 731, 859, 913, 934, 931, 905}
        };
        int startday2 = 1;
        System.out.println(solution(schedules2, timelogs2, startday2)); // 2
    }

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        int saturday = (13 - startday) % 7;
        int sunday = (14 - startday) % 7;

        for(int i=0;i<timelogs.length;i++) {
            int s = schedules[i];
            int h = s / 100;
            int m = s % 100 + 10;

            if(m >= 60) {
                h += 1;
                m %= 60;
            }

            int limitHour = h * 100;
            int limitTime = limitHour + m;

            boolean isPass = true;

            for(int j=0;j<timelogs[i].length;j++) {
                if(j == saturday || j == sunday) {
                    continue;
                }

                if(timelogs[i][j] > limitTime) {
                    isPass = false;
                    break;
                }
            }

            if(isPass) {
                answer += 1;
            }
        }

        return answer;
    }
}
