package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s1_15903 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        for(int i=0;i<m;i++) {
            if(pq.size() >= 2) {
                Long x = pq.poll();
                Long y = pq.poll();
                Long sum = x + y;
                pq.offer(sum);
                pq.offer(sum);
            }
        }

        Long answer = 0L;
        int size = pq.size();
        for(int i=0;i<size;i++) {
            Long p = pq.poll();
            answer += p;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
