package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

// DP
public class 구현_s2_11053 {

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

        int[] dp = new int[N];
        for(int i=0;i<N;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

//        int[] dp = new int[N];
//        for(int i=N-1;i>=0;i--) {
//            dp[i] = 1;
//            for(int j=N-1;j>i;j--) {
//                if(arr[i] < arr[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }

//        for(int i=0;i<dp.length;i++) {
//            System.out.print(dp[i] + " ");
//        }

        int answer = 0;
        for(int i=0;i<dp.length;i++) {
            if(answer < dp[i]) {
                answer = dp[i];
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
