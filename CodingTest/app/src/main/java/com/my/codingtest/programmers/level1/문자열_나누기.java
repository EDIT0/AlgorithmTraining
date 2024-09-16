package com.my.codingtest.programmers.level1;

public class 문자열_나누기 {

    public static void main(String[] args) {
        String s1 = "banana";
        String s2 = "abracadabra";
        String s3 = "aaabbaccccabba";

        System.out.println(solution(s3) + "");
    }

    public static int solution(String s) {
        int answer = 0;

        String currentString = "";
        int x = 0;
        int y = 0;

        for (int i=0;i<s.length();i++) {
            if(currentString.equals("")) {
                currentString = String.valueOf(s.charAt(i));
                x += 1;
            } else if(currentString.equals(String.valueOf(s.charAt(i)))) {
                x += 1;
            } else {
                y += 1;
            }

            if(x == y) {
                x = 0;
                y = 0;
                currentString = "";
                answer += 1;
            }
        }

        if(x != 0 || y != 0) {
            answer += 1;
        }

        return answer;
    }

}
