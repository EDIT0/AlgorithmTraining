package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s4_2164 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            Queue queue = new LinkedList();

            for(int i=1;i<=N;i++) {
                queue.add(i);
            }

            while(queue.size() > 1) {
                queue.poll();
                int temp = (int) queue.poll();
                queue.offer(temp);
            }

            bw.write(queue.poll() + "");


            // 시간초과
//            Stack<Integer> stack = new Stack<Integer>();
//            for(int i=N;i>=1;i--) {
//                stack.add(i);
//            }
//
//            while (stack.size() > 1) {
//                stack.pop();
//                if(stack.size() == 1) break;
//                int toBottom = stack.peek();
//                stack.pop();
//                stack.add(0, toBottom);
//            }
//
//            bw.write(stack.peek() + "");
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
