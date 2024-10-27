package com.my.codingtest.programmers.level1;

import java.util.Arrays;

public class 정수_내림차순으로_배치하기 {

    public static void main(String[] args) {
        int n = 118372;

        System.out.println(solution(n) + "");
    }

    public static long solution(long n) {
        long answer = 0;

        String[] arr = (n+"").split("");
//        Arrays.sort(arr, Comparator.reverseOrder());
        Arrays.sort(arr, (o1, o2) -> {
            return o2.compareTo(o1);
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++) {
            sb.append(arr[i]);
        }

        answer = Long.parseLong(sb.toString());

        return answer;
    }

}
