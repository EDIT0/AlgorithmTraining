package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s5_1417 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        int my = Integer.parseInt(br.readLine());
        for(int i=1;i<N;i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            int p = pq.poll();
            if(my <= p) {
                p -= 1;
                answer += 1;
                my += 1;
            } else {
                break;
            }
            pq.add(p);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
