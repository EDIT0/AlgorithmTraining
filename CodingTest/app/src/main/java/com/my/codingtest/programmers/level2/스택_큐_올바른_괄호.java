package com.my.codingtest.programmers.level2;

import java.util.Stack;

public class 스택_큐_올바른_괄호 {

    public static void main(String[] args) {
        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        System.out.println(solution(s1) + "");
    }

    public static boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++) {
            if(String.valueOf(s.charAt(i)).equals("(")) {
                stack.add(s.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    answer = false;
                    return answer;
                } else {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }

}
