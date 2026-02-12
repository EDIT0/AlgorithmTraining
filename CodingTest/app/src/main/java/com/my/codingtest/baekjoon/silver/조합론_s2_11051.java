package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 조합론_s2_11051 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[1001][1001];

        // 1로 초기화
        for(int i=0;i<=1000;i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        // 파스칼 삼각형 성질
        for(int i=2;i<=1000;i++) {
            for(int j=1;j<i;j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % 10007 ;
            }
        }

        int answer = dp[N][K];

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
