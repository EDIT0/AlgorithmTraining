package com.my.codingtest.programmers.level2;

import java.util.Arrays;

public class 스택_큐_주식가격 {

    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 2, 3 };


        System.out.println(Arrays.toString(solution(prices)) + "");
    }

    public static int[] solution(int[] prices) {
        int[] answer = {};

        answer = new int[prices.length];
        for(int i=0;i<prices.length;i++) {
            int price = prices[i];
            int sum = 0;
            for(int j=i+1;j<prices.length;j++) {
                sum++;
                if(prices[j] < price) {
                    break;
                }
            }
            answer[i] = sum;
        }

        return answer;
    }

}
