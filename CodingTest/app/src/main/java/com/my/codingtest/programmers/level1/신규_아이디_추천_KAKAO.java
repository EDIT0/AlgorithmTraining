package com.my.codingtest.programmers.level1;

import java.util.regex.Pattern;

public class 신규_아이디_추천_KAKAO {
    public static void main(String[] args) {
        String new_id_1 = "...!@BaT#*..y.abcdefghijklm";
        String new_id_2 = "z-+.^.";
        String new_id_3 = "=.=";
        String new_id_4 = "123_.def";
        String new_id_5 = "abcdefghijklmn.p";

        System.out.println(solution(new_id_1) + "");
    }

    public static String solution(String new_id) {
        String answer = "";

        String regex = "~!@#$%^&*()=+[{]}:?,<>/";

        // 모든 대문자를 대응되는 소문자로 치환
        new_id = new_id.toLowerCase();
//        System.out.println(new_id);

        // 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        for(int i=0;i<new_id.length();i++) {
            if(regex.contains(String.valueOf(new_id.charAt(i)))) {
                new_id = new_id.replaceAll(Pattern.quote("" + new_id.charAt(i)), " ");
            }
        }
        new_id = new_id.replaceAll(" ", "");
//        System.out.println(new_id);

        // 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        boolean key = true;
        while (key) {
            String tmp = new String(new_id);
            new_id = new_id.replaceFirst("\\.\\.", "\\.");
//            System.out.println(new_id);
            if(tmp.equals(new_id)) {
                key = false;
            }
        }
//        System.out.println(new_id);

        // 마침표(.)가 처음이나 끝에 위치한다면 제거
        while (!new_id.isEmpty() && ("" + new_id.charAt(0)).equals(".")) {
            new_id = new_id.substring(1, new_id.length());
        }
        while (!new_id.isEmpty() && ("" + new_id.charAt(new_id.length()-1)).equals(".")) {
            new_id = new_id.substring(0, new_id.length()-1);
        }
//        System.out.println(new_id);

        // 빈 문자열이라면, new_id에 "a"를 대입
        if(new_id.isEmpty()) {
            new_id = "a";
        }
//        System.out.println(new_id);

        // 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
        if(new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
        } else {
            new_id = new_id.substring(0, new_id.length());
        }
        while (!new_id.isEmpty() && ("" + new_id.charAt(0)).equals(".")) {
            new_id = new_id.substring(1, new_id.length());
        }
        while (!new_id.isEmpty() && ("" + new_id.charAt(new_id.length()-1)).equals(".")) {
            new_id = new_id.substring(0, new_id.length()-1);
        }
//        System.out.println(new_id);

        // 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(new_id.length() < 3) {
            char c = new_id.charAt(new_id.length()-1);
            while (new_id.length() < 3) {
                new_id += c;
            }
        }
//        System.out.println(new_id);

        answer = new_id;

        return answer;
    }
}
