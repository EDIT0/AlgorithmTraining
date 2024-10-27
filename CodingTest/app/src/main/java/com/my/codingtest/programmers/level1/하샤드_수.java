package com.my.codingtest.programmers.level1;

public class 하샤드_수 {

    public static void main(String[] args) {
        int x = 10;

        System.out.println(solution(x) + "");
    }

    public static boolean solution(int x) {
        boolean answer = true;

        String numString = x + "";

        int sum = 0;
        for(int i=0;i<numString.length();i++) {
            sum += Integer.parseInt(String.valueOf(numString.charAt(i)));
        }

        if(x % sum != 0) {
            answer = false;
        }

        return answer;
    }
}
