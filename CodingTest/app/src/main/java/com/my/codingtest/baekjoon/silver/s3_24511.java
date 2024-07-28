package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s3_24511 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine());

            int[] stackOrQueueArr = new int[N];
            int[] arr = new int[N];
            Deque deque = new ArrayDeque();

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                stackOrQueueArr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if(stackOrQueueArr[i] == 0) {
                    deque.add(arr[i]);
                }
            }

            int M = Integer.parseInt(br.readLine());

            int C;

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++) {
                C = Integer.parseInt(st.nextToken());

                deque.offerFirst(C);
                bw.write(deque.pollLast() + " ");
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }
}
