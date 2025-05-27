package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s4_10828 {

    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String order = st.nextToken();

                orderFunc(order, st, bw);

            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void orderFunc(String o, StringTokenizer st, BufferedWriter bw) throws Exception {
        switch (o) {
            case "push": {
                int num = Integer.parseInt(st.nextToken());
                stack.add(num);
                break;
            }
            case "pop": {
                if(stack.isEmpty()) {
                    bw.write("-1" + "\n");
                } else {
                    int pop = stack.pop();
                    bw.write(pop + "\n");
                }
                break;
            }
            case "size": {
                if(stack.isEmpty()) {
                    bw.write("0" + "\n");
                } else {
                    bw.write(stack.size() + "\n");
                }
                break;
            }
            case "empty": {
                if(stack.isEmpty()) {
                    bw.write("1" + "\n");
                } else {
                    bw.write("0" + "\n");
                }
                break;
            }
            case "top": {
                if(stack.isEmpty()) {
                    bw.write("-1" + "\n");
                } else {
                    bw.write(stack.peek() + "\n");
                }
                break;
            }
        }
    }
}
