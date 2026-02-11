package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.math.*;
import java.util.*;

public class 조합론_s3_2407 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger[][] dp = new BigInteger[101][101];

        // 1로 초기화
        for(int i=0;i<=100;i++) {
            dp[i][0] = BigInteger.valueOf(1);
            dp[i][i] = BigInteger.valueOf(1);
        }

        // 파스칼 삼각형 성질
        for(int i=2;i<=100;i++) {
            for(int j=1;j<i;j++) {
                dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
            }
        }

        BigInteger answer = dp[n][m];

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
