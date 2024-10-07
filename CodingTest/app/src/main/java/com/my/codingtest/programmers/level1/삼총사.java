package com.my.codingtest.programmers.level1;

public class 삼총사 {

    public static void main(String[] args) {
        int[] number1 = {-2, 3, 0, 2, -5}; // 2
        int[] number2 = {-3, -2, -1, 0, 1, 2, 3}; // 5
        int[] number3 = {-1, 1, -1, 1}; // 0


        System.out.println(solution(number3) + "");
    }

    public static int solution(int[] number) {
        int answer = 0;

        for(int i=0;i<number.length-2;i++) {
            for(int j=i+1;j<number.length-1;j++) {
                for(int k=j+1;k<number.length;k++) {
                    int sum = number[i] + number[j] + number[k];
                    if(sum == 0) {
                        answer += 1;
                    }
                }
            }
        }

        return answer;
    }

}
