package com.my.codingtest.programmers.level1;

public class 콜라츠_추측 {
    public static void main(String[] args) {
        int n1 = 6;
        int n2 = 626331;
        int n3 = 16;

        System.out.println(solution(n2) + "");
    }

    public static int solution(int num) {
        int answer = 0;

        if(num == 1) return 0;

        int loopCount = 0;
        long n = num;
        while (true) {
            loopCount += 1;
            if(n%2 == 0) {
                n /= 2;
            } else {
                n = n*3+1;
            }
            if(n == 1) {
                break;
            }
            if(loopCount == 500) {
                loopCount = -1;
                break;
            }
        }

        answer = loopCount;

        return answer;
    }
}
