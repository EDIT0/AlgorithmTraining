package com.my.codingtest.programmers.level1;

public class 핸드폰_번호_가리기 {

    public static void main(String[] args) {
        String phone_number = "01033334444";

        System.out.println(solution(phone_number) + "");
    }

    public static String solution(String phone_number) {
        String answer = "";

        for(int i=0;i<phone_number.length()-4;i++) {
            answer += "*";
        }

        answer += phone_number.substring(phone_number.length()-4, phone_number.length());

        return answer;
    }

}
