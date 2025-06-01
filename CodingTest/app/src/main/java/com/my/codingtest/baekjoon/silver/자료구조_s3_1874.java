package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s3_1874 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();

            StringBuilder output = new StringBuilder();

            for(int i=0;i<n;i++) {
                int num = Integer.parseInt(br.readLine());
                queue.add(num);
            }

            int current = 1;
            boolean isFinish = false;

            while (!queue.isEmpty()) {
                int target = queue.peek();

                if (!stack.isEmpty() && stack.peek() == target) {
                    stack.pop();
                    queue.poll();
                    output.append("-\n");
                } else if (current <= target) {
                    stack.push(current++);
                    output.append("+\n");
                } else {
                    isFinish = true;
                    break;
                }
            }

            if (isFinish) {
                bw.write("NO\n");
            } else {
                bw.write(output.toString());
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
