package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class DP_b1_2775 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호

            int[][] dp = new int[k+1][n+1];

            for(int j=1;j<=n;j++) {
                dp[0][j] = j;
            }

            for(int j=1;j<=k;j++) {
                for(int h=1;h<n;h++) {
                    dp[j][h] = dp[j-1][h] + dp[j][h-1];
                }
                dp[j][n] = dp[j-1][n] + dp[j][n-1];
            }
            bw.write(dp[k][n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
