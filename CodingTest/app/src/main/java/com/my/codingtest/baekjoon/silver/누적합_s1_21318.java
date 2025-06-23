package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 누적합_s1_21318 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int[] arr;
    public static int before = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1;i<=N;i++) {
            int n = Integer.parseInt(st.nextToken());
            int a = 0;
            if(before > n) {
                a = 1;
            }
            arr[i] = a + arr[i-1];
            before = n;
        }

//        System.out.println();
//        for(int i=1;i<=N;i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();

        int Q = Integer.parseInt(br.readLine());
        for(int i=0;i<Q;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            bw.write(arr[y] - arr[x] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
