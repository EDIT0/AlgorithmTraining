package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 그리디_g3_2812 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String numStr = br.readLine();

        Stack<Character> stack = new Stack<>();

        /**
         * 4 2
         * 1924
         * -> 94
         *
         * 7 3
         * 1231234
         * -> 3234
         *
         * 10 4
         * 4177252841
         * -> 775841
         */
        for(int i=0;i<numStr.length();i++) {
            char c = numStr.charAt(i);

            while (!stack.isEmpty() && c > stack.lastElement() && K > 0) {
                stack.pop();
                K -= 1;
            }

            stack.push(c);
        }

        while (K > 0) {
            stack.pop();
            K--;
        }

        StringBuilder answer = new StringBuilder();
        for (char c : stack) {
            answer.append(c);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
