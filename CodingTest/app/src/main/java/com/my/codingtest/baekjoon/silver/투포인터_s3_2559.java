package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 투포인터_s3_2559 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

//        int[] arr = new int[N+1];
//        st = new StringTokenizer(br.readLine(), " ");
//        for(int i=1;i<=N;i++) {
//            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
//        }
//
//        int max = Integer.MIN_VALUE;
//        for(int i=K;i<=N;i++) {
//            int n = arr[i] - arr[i-K];
//            if(max < n) {
//                max = n;
//            }
//        }

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int currentSum = 0;
        for(int i=0;i<K;i++) {
            currentSum += arr[i];
        }
        max = currentSum;

        for(int i=K;i<N;i++) {
            currentSum = currentSum - arr[i-K] + arr[i];
            if(max < currentSum) {
                max = currentSum;
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
