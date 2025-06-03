package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s2_1927 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Long> numQueue = new PriorityQueue<>((o1, o2) -> {
                if(o2 - o1 >= 0) {
                    return -1;
                } else {
                    return 1;
                }
            });

            for(int i=0;i<N;i++) {
                long num = Long.parseLong(br.readLine());
                if(num == 0) {
                    if(numQueue.isEmpty()) {
                        bw.write("0\n");
                    } else {
                        bw.write(numQueue.poll() + "\n");
                    }
                } else {
                    numQueue.add(num);
                }
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
