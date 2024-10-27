package com.my.codingtest.programmers.level1;

public class 정수_제곱근_판별 {

    public static void main(String[] args) {
        int n1 = 121;
        int n2 = 3;

        System.out.println(solution(n2) + "");
    }

    public static long solution(long n) {
        long answer = 0;

        double a = Math.sqrt(n);
        int b = (int) a;

        if(a > b) {
            answer = -1;
        } else {
            a += 1;
            answer = (long) Math.pow(a, 2);
        }

        return answer;
    }

}
