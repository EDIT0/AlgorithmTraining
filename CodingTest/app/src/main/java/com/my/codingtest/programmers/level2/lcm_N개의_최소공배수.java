package com.my.codingtest.programmers.level2;

public class lcm_N개의_최소공배수 {

    public static void main(String[] args) {
        int[] arr1 = {2, 6, 8, 14};
        // 168

        int[] arr2 = {1, 2, 3};
        // 6

        System.out.println(solution(arr1) + "");
    }

    public static int solution(int[] arr) {
        int answer = 0;

        long start = arr[0];

        for(int i=1;i<arr.length;i++) {
            start = lcm(start, arr[i]);
        }

        answer = (int) start;

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
