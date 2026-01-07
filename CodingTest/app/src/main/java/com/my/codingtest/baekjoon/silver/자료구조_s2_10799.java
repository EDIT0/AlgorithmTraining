package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s2_10799 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for(int i=0;i<str.length();i++) {
            char input = str.charAt(i);

            if(stack.isEmpty()) {
                stack.push(input);
                continue;
            }

            if(input == '(') {
                stack.push(input);
            } else {
                char pop = stack.pop();
                if(str.charAt(i-1) == '(') {
                    answer += stack.size();
                } else {
                    answer += 1;
                }
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

        // ()(((()())(())()))(()) -> 17
        // () (((() () ) (() )  ()  )  )   (() )
        //s:0   3   3  2  3  2   2  1  0    1  0
        //a:0   3   6  8  11 13  15 16 16   17 17
    }

}
