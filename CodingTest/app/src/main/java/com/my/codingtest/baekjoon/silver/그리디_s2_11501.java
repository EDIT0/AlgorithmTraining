package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s2_11501 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[N];
            for(int j=0;j<N;j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            long profit = 0;
            for(int j=arr.length-1;j>=0;j--) {
                if(max <= arr[j]) {
                    max = arr[j];
                } else {
                    profit += (max - arr[j]);
                }
            }

            bw.write(profit + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
