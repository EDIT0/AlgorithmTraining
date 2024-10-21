package com.my.codingtest.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 탐욕법_체육복 {
    public static void main(String[] args) {
        int n1 = 5;
        int[] lost1 = {2, 4};
        int[] reserve1 = {1, 3, 5};
        // 5

        int n2 = 5;
        int[] lost2 = {2, 4};
        int[] reserve2 = {3};
        // 4

        int n3 = 3;
        int[] lost3 = {3};
        int[] reserve3 = {1};
        // 2

        int n4 = 5;
        int[] lost4 = {1, 2};
        int[] reserve4 = {2, 3};
        // 4

        int n5 = 5;
        int[] lost5 = {2, 3, 4};
        int[] reserve5 = {1, 2, 3};
        // 4

        System.out.println(solution(n5, lost5, reserve5) + "");
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        Map<Integer, Boolean> hashMap = new HashMap<>();

        // 여분이 있는 학생들만 true
        for(int i=0;i<reserve.length;i++) {
            hashMap.put(reserve[i], true);
        }

        int lostIndex = 0;
        // 여분이 있지만 잃어버린 학생 제거
        for(int i=1;i<=n;i++) {
            if(lostIndex == lost.length) {
                break;
            }
            if(hashMap.containsKey(lost[lostIndex])) {
                hashMap.remove(lost[lostIndex]);
                lost[lostIndex] = -1;
                lostIndex += 1;
            } else {
                lostIndex += 1;
            }
        }

//        System.out.println(Arrays.toString(lost));
//        System.out.println(hashMap.toString());

        lostIndex = 0;
        for(int i=1;i<=n;i++) {
            if(lostIndex == lost.length) {
                answer += 1;
//                System.out.println("1. " + i + " up = " + answer);
                continue;
            }

            if(lost[lostIndex] == -1) {
                lostIndex += 1;
                answer += 1;
//                System.out.println("2. " + i + " up = " + answer);
                continue;
            }
            if(i == lost[lostIndex]) {
                if(hashMap.containsKey(i-1)) {
                    hashMap.remove(i-1);
                    answer += 1;
//                    System.out.println("특별업 1 " + i + " "  + answer);
                } else if(hashMap.containsKey(i+1)) {
                    hashMap.remove(i+1);
                    answer += 1;
//                    System.out.println("특별업 2 " + i + " " + answer);
                }
                lostIndex += 1;
            } else {
                answer += 1;
//                System.out.println("3. " + i + " up = " + answer);
            }
        }

        return answer;
    }
}
