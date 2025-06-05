package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s1_11286 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
        if(Math.abs(o1) > Math.abs(o2)) {
            return 1;
        } else if(Math.abs(o1) < Math.abs(o2)) {
            return -1;
        } else {
            if(o1 > o2) {
                return 1;
            } else if(o1 < o2){
                return -1;
            } else {
                return -1;
            }
        }
    });

    public static void main(String[] args) {

        try {
            int N = Integer.parseInt(br.readLine());

            for(int i=0;i<N;i++) {
                int num = Integer.parseInt(br.readLine());
                if(num == 0) {
                    if(!priorityQueue.isEmpty()) {
                        bw.write(priorityQueue.poll() + "\n");
                    } else {
                        bw.write("0\n");
                    }
                } else {
                    priorityQueue.add(num);
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
