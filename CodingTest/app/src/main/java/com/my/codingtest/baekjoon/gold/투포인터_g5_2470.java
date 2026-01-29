package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 투포인터_g5_2470 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * 5
         * -2 4 -99 -1 98
         *
         * -99 98
         */

        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;
        int a = 0;
        int b = 0;
        int min = Integer.MAX_VALUE;

        while (start < end) {
            if(start >= N || end < 0) {
                break;
            }
            int m = arr[start] + arr[end];
            if(Math.abs(min) > Math.abs(m)) {
                min = m;
                a = arr[start];
                b = arr[end];
            }
            if(m > 0) {
                end -= 1;
            } else if(m < 0) {
                start += 1;
            } else {
                break;
            }
        }

        bw.write(a + " " + b);
        bw.flush();
        bw.close();
        br.close();
    }
}
