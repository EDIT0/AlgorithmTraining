package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s3_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int expectedNumber = 1;
        boolean possible = true;

        while (!queue.isEmpty() || !stack.isEmpty()) {
            if (!queue.isEmpty() && queue.peek() == expectedNumber) {
                queue.poll();
                expectedNumber++;
            } else if (!stack.isEmpty() && stack.peek() == expectedNumber) {
                stack.pop();
                expectedNumber++;
            } else if (!queue.isEmpty()) {
                stack.push(queue.poll());
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            bw.write("Nice");
        } else {
            bw.write("Sad");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
