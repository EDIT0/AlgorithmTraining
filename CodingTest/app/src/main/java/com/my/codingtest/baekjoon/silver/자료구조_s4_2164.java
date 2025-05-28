package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s4_2164 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();

            for(int i=1;i<=N;i++) {
                queue.add(i);
            }

            boolean key = true;
            while (queue.size() > 1) {
                if(key) {
                    key = false;
                    queue.poll();
                } else {
                    key = true;
                    int n = queue.poll();
                    queue.add(n);
                }
            }

            bw.write(queue.poll() + "");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
