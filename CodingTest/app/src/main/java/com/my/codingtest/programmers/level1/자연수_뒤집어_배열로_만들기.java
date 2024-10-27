package com.my.codingtest.programmers.level1;

import java.util.Arrays;

public class 자연수_뒤집어_배열로_만들기 {

    public static void main(String[] args) {
        int n = 12345;

        System.out.println(Arrays.toString(solution(n)) + "");
    }

    public static int[] solution(long n) {
        int[] answer = {};

        String nString = n + "";

        answer = new int[nString.length()];

        int index = 0;
        for(int i=nString.length()-1;i>=0;i--) {
            answer[index] = Integer.parseInt(String.valueOf(nString.charAt(i)));
            index += 1;
        }

        return answer;
    }

}
