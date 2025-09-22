package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 완전탐색_DP_s1_1149 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][3];

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = r;
            arr[i][1] = g;
            arr[i][2] = b;
        }

        /**
         * 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
         * N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
         * i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
         *
         * 첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다.
         * 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다.
         * 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
         */

        int[][] dp = new int[N+1][3];

        if(N >= 1) {
            dp[1][0] = arr[1][0];
            dp[1][1] = arr[1][1];
            dp[1][2] = arr[1][2];
        }

        for(int i=2;i<=N;i++) {
            dp[i][0] = Math.min(arr[i][0] + dp[i-1][1], arr[i][0] + dp[i-1][2]);
            dp[i][1] = Math.min(arr[i][1] + dp[i-1][0], arr[i][1] + dp[i-1][2]);
            dp[i][2] = Math.min(arr[i][2] + dp[i-1][0], arr[i][2] + dp[i-1][1]);
        }

        int answer = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
