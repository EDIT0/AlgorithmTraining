package com.my.codingtest.programmers.level1;

public class 짝수와_홀수 {
    public static void main(String[] args) {
        int num = 3;

        System.out.println(solution(num) + "");
    }

    public static String solution(int num) {
        return num%2==0 ? "Even":"Odd";
    }
}
