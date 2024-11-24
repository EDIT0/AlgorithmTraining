package com.my.codingtest.programmers.level2;

import java.util.*;

public class 최댓값과_최솟값 {

    public static void main(String[] args) {
        String s1 = "1 2 3 4";
        String s2 = "-1 -2 -3 -4";
        String s3 = "-1 -1";

        System.out.println(solution(s3));
    }

    public static String solution(String s) {
        String answer = "";

        String[] arrS = s.split(" ");
        String min = "" + Integer.MAX_VALUE;
        String max = "" + Integer.MIN_VALUE;
        for(int i=0;i<arrS.length;i++) {
            if(Integer.parseInt(arrS[i]) < Integer.parseInt(min)) {
                min = arrS[i];
            }
            if(Integer.parseInt(arrS[i]) > Integer.parseInt(max)) {
                max = arrS[i];
            }
        }

        answer = min + " " + max;

        return answer;
    }

}
