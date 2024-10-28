package com.my.codingtest.programmers.level2;

import java.util.Arrays;

public class PCCP_퍼즐_게임_챌린지 {

    public static void main(String[] args) {
        int[] diffs1 = {1, 5, 3};
        int[] times1 = {2, 4, 7};
        long limit1 = 30;
        // 3

        int[] diffs2 = {1, 4, 4, 2};
        int[] times2 = {6, 3, 8, 2};
        long limit2 = 59;
        // 2

        int[] diffs3 = {1, 328, 467, 209, 54};
        int[] times3 = {2, 7, 1, 4, 3};
        long limit3 = 1723;
        // 294

        int[] diffs4 = {1, 99999, 100000, 99995};
        int[] times4 = {9999, 9001, 9999, 9001};
        long limit4 = Long.parseLong("3456789012");
        // 39354

        System.out.println(solution(diffs4, times4, limit4) + "");
    }

    public static int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        answer = (int) calLevel(1, Long.parseLong(String.valueOf(Arrays.stream(diffs).max().getAsInt())), diffs, times, 1, limit, 0);

//        시간 초과
//        long max = Integer.MIN_VALUE;
//
//        int level = 1;
//        while (true) {
//            long timeSum = 0;
//            for(int i=0;i<diffs.length;i++) {
//                long diff = diffs[i];
//                long time = times[i];
//                long prevTime = 0;
//                if(i > 0) {
//                    prevTime = times[i-1];
//                }
//
////                System.out.println(diff +" / " + time + " / " + level);
//
//                if(diff > level) {
//                    timeSum += ((prevTime + time) * (diff - level) + time);
////                    System.out.println("1. timeSum : " + timeSum);
//                } else if(diff <= level) {
//                    timeSum += time;
////                    System.out.println("2. timeSum : " + timeSum);
//                }
//            }
//
////            System.out.println("timeSum : " + timeSum);
//
//            long d = limit - timeSum;
////            System.out.println("d : " + d + " / current level : " + level + " / max : " + max);
//            if(d >= 0) {
//                max = Math.max(max, d);
////                System.out.println("max : " + max);
//                answer = level;
//                break;
//            } else {
//
//            }
//
//            level += 1;
////            System.out.println("answer : " + answer + "\n");
//        }


        return answer;
    }

    public static int calLevel(long minLevel, long maxLevel, int[] diffs, int[] times, int level, long limit, long prevTimeValue) {
        if(minLevel > maxLevel) {
            if(prevTimeValue < 0) {
                level += 1;
            }
            return level;
        }
        long currentLevel = (minLevel + maxLevel) / 2;

//        System.out.println(minLevel + " / " + maxLevel + " / " + currentLevel);

        long timeSum = 0;
        for(int i=0;i<diffs.length;i++) {
            long diff = diffs[i];
            long time = times[i];
            long prevTime = 0;
            if(i > 0) {
                prevTime = times[i-1];
            }
            if(diff > currentLevel) {
                timeSum += ((prevTime + time) * (diff - currentLevel) + time);
            } else if(diff <= currentLevel) {
                timeSum += time;
            }
        }

        long d = limit - timeSum;
//        System.out.println(d + " = " + limit + " - " + timeSum);
        if(d >= 0) {
            level = calLevel(minLevel, currentLevel-1, diffs, times, (int) currentLevel, limit, d);
        } else {
            level = calLevel(currentLevel+1, maxLevel, diffs, times, (int) currentLevel, limit, d);
        }

        return level;
    }

}
