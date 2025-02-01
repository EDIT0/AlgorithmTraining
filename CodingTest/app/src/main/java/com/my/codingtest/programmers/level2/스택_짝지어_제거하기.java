package com.my.codingtest.programmers.level2;

import java.util.Stack;

public class 스택_짝지어_제거하기 {

    public static void main(String[] args) {
        String s1 = "baabaa";
        // 1

        String s2 = "cdcd";
        // 0

        System.out.println(solution(s1) + "");
    }

    public static int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if(stack.isEmpty()) {
            answer = 1;
        }

        // 효율성 시간 초과
//        StringBuilder sb = new StringBuilder(s);
//
//        int index = 1;
//        while (true) {
//            if(index >= sb.length()) {
//                break;
//            }
//
//            if(sb.charAt(index-1) == sb.charAt(index)) {
//                sb = sb.delete(index-1, index+1);
//                index = 1;
//            } else {
//                index += 1;
//            }
//        }
//
//        if (sb.length() == 0) {
//            answer = 1;
//        }

        return answer;
    }

}
