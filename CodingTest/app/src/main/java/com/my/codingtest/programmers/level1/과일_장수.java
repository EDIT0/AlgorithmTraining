package com.my.codingtest.programmers.level1;

import java.util.Arrays;
import java.util.Collections;

public class 과일_장수 {

    public static void main(String[] args) {
        int k1 = 3;
        int m1 = 4;
        int[] score1 = {1, 2, 3, 1, 2, 3, 1};

        int k2 = 4;
        int m2 = 3;
        int[] score2 = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        System.out.println(solution(k1, m1, score1) + "");
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        Integer[] integerArr = new Integer[score.length];
        for(int i=0;i<score.length;i++) {
            integerArr[i] = score[i];
        }

        Arrays.sort(integerArr, Collections.reverseOrder());

        // (최저 사과 점수) x (한 상자에 담긴 사과 개수) x (상자의 개수)
        for(int i=0;i<integerArr.length;i++) {
            if((i+1)%m == 0) {
                answer += (integerArr[i] * m * 1);
            }
        }

        return answer;
    }

}
