package com.my.codingtest.programmers.level1;

import java.util.Arrays;

public class 예산 {

    public static void main(String[] args) {
        int[] d1 = {1,3,2,5,4};
        int budget1 = 9;
        // 3

        int[] d2 = {2,2,3,3};
        int budget2 = 10;
        // 4

        System.out.println(solution(d2, budget2) + "");
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        int sum = 0;
        for(int i=0;i<d.length;i++) {
            sum += d[i];
            if(sum > budget) {
                sum -= d[i];
                answer = i;
                break;
            } else {
                answer = i+1;
            }
        }

        return answer;
    }

}
