package com.my.codingtest.programmers.level1;

public class 이상한_문자_만들기 {

    public static void main(String[] args) {
        String s = "  try  hello world    ";

        System.out.println(solution(s) + "");
    }

    public static String solution(String s) {
        String answer = "";

        String[] arr = s.split("");

        int index = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals(" ")) {
                index = 0;
            } else if(index % 2 == 0) {
                arr[i] = arr[i].toUpperCase();
                index += 1;
            } else if(index % 2 != 0) {
                arr[i] = arr[i].toLowerCase();
                index += 1;
            }
            answer += arr[i];
        }

        return answer;
    }
    
}
