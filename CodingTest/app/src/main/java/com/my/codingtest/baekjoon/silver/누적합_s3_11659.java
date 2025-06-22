package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 누적합_s3_11659 {


    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1;i<=N;i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = arr[i-1] + n;
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(arr[b] - arr[a-1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
