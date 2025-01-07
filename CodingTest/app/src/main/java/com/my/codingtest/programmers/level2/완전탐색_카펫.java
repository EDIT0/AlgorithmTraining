package com.my.codingtest.programmers.level2;

import java.util.Arrays;

public class 완전탐색_카펫 {
    public static void main(String[] args) {
        int brown1 = 10;
        int yellow1 = 2;
        // {4, 3}

        int brown2 = 8;
        int yellow2 = 1;
        // {3, 3}

        int brown3 = 24;
        int yellow3 = 24;
        // {8, 6}

        System.out.println(Arrays.toString(solution(brown3, yellow3)));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = {};

        int w = 0;
        int h = 0;

        for(int i=1;i<=yellow;i++) {
            if(yellow % i == 0) {
                h = (i + 2) * 2;
                w = (yellow / i) * 2;
            }
            if((w + h) == brown) {
                System.out.println(w + " / " + h);
                System.out.println((yellow/i) + 2 + " / " + h/2);
                answer = new int[]{(yellow/i) + 2, h/2};
                break;
            }
        }

        return answer;
    }
}
