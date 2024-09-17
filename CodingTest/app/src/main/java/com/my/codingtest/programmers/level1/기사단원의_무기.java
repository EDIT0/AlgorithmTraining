package com.my.codingtest.programmers.level1;

import java.util.ArrayList;

public class 기사단원의_무기 {
    public static void main(String[] args) {
        int number1 = 5;
        int limit1 = 3;
        int power1 = 2;

        int number2 = 10;
        int limit2 = 3;
        int power2 = 2;

        System.out.println(solution(number2, limit2, power2) + "");
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i=1;i<=number;i++) {
            int n = i;
            int count = 0;
            for(int j=1;j<=Math.sqrt(n);j++) { // 제곱근만 돌리고
                if(n % j == 0) {
                    count++;
                    if(n / j != j) { // j로 나눠서 0인 것을 다시 j로 나눈다. 그 값이 j랑 같으면 추가하지 않고, 다르면 추가
                        count++;
                    }
                }
            }
            list.add(count);
        }

        for(int i=0;i<list.size();i++) {
            if(limit < list.get(i)) {
                answer += power;
            } else {
                answer += list.get(i);
            }
        }

        return answer;
    }
}
