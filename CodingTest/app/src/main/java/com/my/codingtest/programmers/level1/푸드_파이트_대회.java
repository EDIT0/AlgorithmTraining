package com.my.codingtest.programmers.level1;

public class 푸드_파이트_대회 {

    public static void main(String[] args) {
        int[] food1 = {1, 3, 4, 6};
        int[] food2 = {1, 7, 1, 2};

        System.out.println(solution(food1) + "");
    }

    public static String solution(int[] food) {
        String answer = "";

        int index = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<food.length;i++) {
            int count = food[i] / 2;
            for(int j=0;j<count;j++) {
                sb.append(index);
            }
            index += 1;
        }

        StringBuilder result = new StringBuilder(sb);
        StringBuilder reverse = sb.reverse();
        result.append(0);
        result.append(reverse);

        answer = result.toString();

        return answer;
    }

}
