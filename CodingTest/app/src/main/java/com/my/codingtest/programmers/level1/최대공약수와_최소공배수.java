package com.my.codingtest.programmers.level1;

import java.util.Arrays;

public class 최대공약수와_최소공배수 {

    public static void main(String[] args) {
        int n = 3;
        int m = 12;

        System.out.println(Arrays.toString(solution(n, m)) + "");
    }

    public static int[] solution(int n, int m) {
        int[] answer = {};

        answer = new int[2];
        answer[0] = (int) gdc(n, m);
        answer[1] = (int) lcm(n, m);

        return answer;
    }

    // 최대 공약수
    public static long gdc(long a, long b) {
        if(a < b) { // 유클리드 호제법 조건
            long tmp = a;
            a = b;
            b = tmp;
        }
        while(b != 0) { // 유클리드 호제법
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소 공배수
    public static long lcm(long a, long b) {
        return a * b / gdc(a, b);
    }

}
