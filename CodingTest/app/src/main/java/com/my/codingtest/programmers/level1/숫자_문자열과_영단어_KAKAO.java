package com.my.codingtest.programmers.level1;

public class 숫자_문자열과_영단어_KAKAO {
    public static void main(String[] args) {
        String s1 = "one4seveneight";
        String s2 = "23four5six7";
        String s3 = "2three45sixseven";
        String s4 = "123";

        System.out.println(solution(s1) + "");
    }

    public static int solution(String s) {
        int answer = 0;

        int[] numberArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0;i<strArr.length;i++) {
            s = s.replaceAll(strArr[i], numberArr[i] + "");
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}
