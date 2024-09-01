package com.my.codingtest.programmers.level2;

import java.util.Arrays;

public class 정렬_가장_큰_수 {

    public static void main(String[] args) {
        int[] numbers = new int[] {6, 10, 2};
        int[] numbers2 = new int[] {3, 30, 34, 5, 9};

        System.out.println(solution(numbers2) + "");
    }

    public static String solution(int[] numbers) {
        String answer = "";

        // n를 이어 붙여 만들 수 있는 경우의 수 n!

        String[] strNumbers = new String[numbers.length];

        for(int i=0;i<numbers.length;i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, (o1, o2) -> {
            int num = (o2 + o1).compareTo(o1 + o2);
            return num;
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strNumbers.length;i++) {
            sb.append(strNumbers[i]);
        }

        answer = sb.toString();

        if(answer.startsWith("0")) {
            answer = "0";
        }

        return answer;
    }

}
