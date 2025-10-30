package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class DP_s1_1932 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=i;j++) {
                int input = Integer.parseInt(st.nextToken());
                int a = dp[i-1][j-1] + input;
                int b = dp[i-1][j] + input;
                dp[i][j] = Math.max(a, b);
            }
        }

        int answer = 0;
        for(int i=1;i<=n;i++) {
            answer = Math.max(answer, dp[n][i]);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
