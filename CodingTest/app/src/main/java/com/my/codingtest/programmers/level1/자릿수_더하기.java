package com.my.codingtest.programmers.level1;

import java.util.Arrays;

public class 자릿수_더하기 {

    public static void main(String[] args) {
        int N = 123;

        System.out.println(solution(N) + "");
    }

    public static int solution(int n) {
        int answer = 0;

        String[] arr = (n+"").split("");
        answer = Arrays.stream(arr).mapToInt(Integer::parseInt).sum();

        return answer;
    }

}
