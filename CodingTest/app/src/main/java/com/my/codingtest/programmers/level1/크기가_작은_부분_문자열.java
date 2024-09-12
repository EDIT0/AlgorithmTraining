package com.my.codingtest.programmers.level1;

public class 크기가_작은_부분_문자열 {

    public static void main(String[] args) {
        String t1 = "3141592"; // p~10000
        String p1 = "271"; // 1~18

        String t2 = "500220839878";
        String p2 = "7";

        System.out.println(solution(t1, p1) + "");
    }

    public static int solution(String t, String p) {
        int answer = 0;

        int pLength = p.length();
        int index = 0;

        while ((t.length() - pLength) >= index) {
            String split = t.substring(index, index + pLength);
            if(Long.parseLong(split) <= Long.parseLong(p)) {
                answer += 1;
            }
            index += 1;
        }

        return answer;
    }
}
