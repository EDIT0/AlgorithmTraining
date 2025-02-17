package com.my.codingtest.programmers.level2;

public class 예상_대진표 {

    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        // 3

        System.out.println(solution(n, a, b));
    }

    public static int solution(int n, int a, int b){
        int answer = 0;

        for(int i=0;i<n;i++) {
            if(a == b) {
                answer = i;
                break;
            }
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }

        return answer;
    }

}
