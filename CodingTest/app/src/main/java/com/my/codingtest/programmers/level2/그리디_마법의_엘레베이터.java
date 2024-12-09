package com.my.codingtest.programmers.level2;

public class 그리디_마법의_엘레베이터 {

    public static void main(String[] args) {
        int storey1 = 16;
        // 6

        int storey2 = 2554;
        // 16

        int storey3 = 95;
        // 6

        int storey4 = 57595358;
        // 26

        int storey5 = 56;
        // 9

        int storey6 = 54;
        // 9

        System.out.println(solution(storey6));
    }

    public static int solution(int storey) {
        int answer = 0;

        // -1, +1, -10, +10, -100, +100
        while (storey > 0) {
            System.out.println("s : " + storey);
            int num = storey % 10;
            System.out.println("n : " + num);

            if(num > 5) {
                int remaining = 10 - num;
                answer += remaining;
                storey += remaining;
                System.out.println("num > 5 : " + storey);
            } else if(num == 5) {
                answer += num;
                System.out.println(storey + num + " 이거?..");
                if((storey/10) % 10 >= 5) {
                    storey += num;
                } else {
                    storey -= num;
                }
                System.out.println("num == 5 : " + storey);
            } else if(num < 5){
                answer += num;
                storey -= num;
                System.out.println("num < 5 : " + storey);
            }
            storey /= 10; // 54 -> 50 -> 5

            System.out.println("storey : " + storey + " / num : " + num +  " / answer : " + answer);
        }

        return answer;
    }

}
