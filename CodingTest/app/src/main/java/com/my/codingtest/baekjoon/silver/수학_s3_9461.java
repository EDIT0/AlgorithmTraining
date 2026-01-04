package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 수학_s3_9461 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;

        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());

            long answer = 0;
            if(N < 5) {
                answer = dp[N];
            } else {
                for(int j=5;j<=N;j++) {
                    dp[j] = dp[j-1] + dp[j-5];
                }
                answer = dp[N];
            }
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
