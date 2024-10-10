package com.my.codingtest.programmers.level1;

public class 부족한_금액_계산하기 {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        // 10

        System.out.println(solution(price, money, count) + "");
    }

    public static long solution(int price, int money, int count) {
        long answer = -1;

        long totalMoney = 0;
        for(int i=0;i<count;i++) {
            totalMoney += ((long) price * (i+1));
        }

        if(totalMoney <= money) {
            answer = 0;
        } else {
            answer = totalMoney - money;
        }

        return answer;
    }
}
