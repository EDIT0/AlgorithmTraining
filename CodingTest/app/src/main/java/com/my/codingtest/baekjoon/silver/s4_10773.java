package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s4_10773 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int K = Integer.parseInt(br.readLine());

            Stack<Integer> integerStack = new Stack<>();

            int result = 0;

            for(int i=0;i<K;i++) {
                int input = Integer.parseInt(br.readLine());

                if(input == 0) {
                    int pop = integerStack.pop();
                    result -= pop;
                } else {
                    integerStack.add(input);
                    result += input;
                }
            }

            bw.write(result + "");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }
}
