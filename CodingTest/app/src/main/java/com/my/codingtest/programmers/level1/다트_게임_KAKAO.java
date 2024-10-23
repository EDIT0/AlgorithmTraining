package com.my.codingtest.programmers.level1;

import java.util.Arrays;

public class 다트_게임_KAKAO {

    public static void main(String[] args) {
        String dartResult1 = "1S2D*3T";
        String dartResult2 = "1D2S#10S";
        String dartResult3 = "1D2S0T";
        String dartResult4 = "1S*2T*3S";
        String dartResult5 = "1D#2S*3S";
        String dartResult6 = "1T2D3D#";
        String dartResult7 = "1D2S3T*";


        System.out.println(solution(dartResult1) + "");
    }

    public static int solution(String dartResult) {
        int answer = 0;

        int[] result = new int[3];

        for(int i=0;i<3;i++) {
            int sum = 0;

            int num = getNumber(dartResult);
            int numLength = String.valueOf(num).length();
            dartResult = dartResult.substring(numLength, dartResult.length());

            String bonus = dartResult.substring(0, 1);
            dartResult = dartResult.substring(1, dartResult.length());

            sum = calBonus(bonus, num);

            if(dartResult.length() > 0) {
                String option = String.valueOf(dartResult.charAt(0));
                if(option.equals("*") || option.equals("#")) {
                    dartResult = dartResult.substring(1, dartResult.length());
                    sum = calOption(result, option, sum, i);
                }
            }

            result[i] = sum;

        }

        for(int i=0;i<result.length;i++) {
            answer += result[i];
        }

        return answer;
    }

    public static int getNumber(String str) {
        String num = "";
        for(int i=0;i<2;i++) {
            try {
                num += Integer.parseInt(String.valueOf(str.charAt(i)));
            } catch (Exception e) {

            }
        }
        return Integer.parseInt(num);
    }

    public static int calBonus(String bonus, int sum) {
        switch (bonus) {
            case "S": {
                return sum;
            }
            case "D": {
                return sum * sum;
            }
            case "T": {
                return sum * sum * sum;
            }
        }
        return sum;
    }

    public static int calOption(int[] result, String option, int sum, int order) {
        switch (option) {
            case "*": {
                if(order == 0) {
                    sum *= 2;
                } else {
                    int beforeSum = result[order-1];
                    beforeSum *= 2;
                    result[order-1] = beforeSum;
                    sum *= 2;
                }
                return sum;
            }
            case "#": {
                return -sum;
            }
        }
        return sum;
    }
}
