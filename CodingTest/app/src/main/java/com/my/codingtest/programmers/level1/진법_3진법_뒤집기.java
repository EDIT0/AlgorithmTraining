package com.my.codingtest.programmers.level1;

public class 진법_3진법_뒤집기 {

    public static void main(String[] args) {
        int n1 = 45;
        int n2 = 125;

        System.out.println(solution(n2) + "");
    }

    public static int solution(int n) {
        int answer = 0;

        String a = "";
        while (n > 0) {
            a = a + (n%3);
            n /= 3;
        }

        for(int i=0;i<a.length();i++) {
            answer += (int) (Integer.parseInt(String.valueOf(a.charAt(i))) * Math.pow(3, (a.length() - i - 1)));
        }

        return answer;
    }

}
