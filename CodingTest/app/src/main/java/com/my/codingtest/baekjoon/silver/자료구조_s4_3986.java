package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s4_3986 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            Stack<String> stack = new Stack<>();
            int count = 0;

            for(int i=0;i<N;i++) {
                String input = br.readLine();
                if(input.length() % 2 == 1) {
                    continue;
                }

                stack.clear();

                for(int j=0;j<input.length();j++) {
                    String word = String.valueOf(input.charAt(j));

                    if(stack.isEmpty()) {
                        stack.add(word);
                    } else {
                        if(word.equals(stack.peek())) {
                            stack.pop();
                        } else {
                            stack.add(word);
                        }
                    }
                }

                if(stack.isEmpty()) {
                    count += 1;
                }
            }

            bw.write(count + "\n");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
