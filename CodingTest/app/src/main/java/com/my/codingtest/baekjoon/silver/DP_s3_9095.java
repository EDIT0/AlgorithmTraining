package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class DP_s3_9095 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2; // 1+1, 2
        dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

        for(int i=0;i<T;i++) {
            int n = Integer.parseInt(br.readLine());

            if(n >= 4) {
                for(int j=4;j<=n;j++) {
                    dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
                }
            }
            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
