package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s3_2075 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
                if(o2 - o1 > 0) {
                    return 1;
                } else {
                    return -1;
                }
            });

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0;j<N;j++) {
                    priorityQueue.add(Integer.parseInt(st.nextToken()));
                }
            }

            for(int i=0;i<N;i++) {
                if(i == N-1) {
                    bw.write(priorityQueue.poll() + "");
                }
                priorityQueue.poll();
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
