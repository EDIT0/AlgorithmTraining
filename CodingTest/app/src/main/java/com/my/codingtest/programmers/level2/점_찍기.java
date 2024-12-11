package com.my.codingtest.programmers.level2;

public class 점_찍기 {
    public static void main(String[] args) {
        int k1 = 2;
        int d1 = 4;
        // 6

        int k2 = 1;
        int d2 = 5;
        // 26

        System.out.println(solution(k2, d2));
    }

    public static long solution(int k, int d) {
        long answer = 0;

        long z = (long) Math.pow(d, 2);

        for(int i=0;i<=d;i+=k) {
            long x = (long) Math.pow(i, 2);

            long y = z - x;

            // 피타고라스 정리
            // y = z - x, y의 제곱근을 정수로 변경한 값 만큼 올 수 있음 (i, y의 정수 제곱근)

            long limitY = (long) Math.sqrt(y);

            answer += limitY / k + 1; // 0도 포함시켜주기
        }

        return answer;
    }
}
