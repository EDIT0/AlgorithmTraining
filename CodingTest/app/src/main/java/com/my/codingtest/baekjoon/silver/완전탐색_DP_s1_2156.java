package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 완전탐색_DP_s1_2156 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];
        if(n >= 1) {
            dp[1] = arr[1];
        }

        if(n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        if(n >= 3) {
            dp[3] = Math.max(Math.max(arr[1] + arr[2], arr[1] + arr[3]), arr[2] + arr[3]);
        }

        // 안마시는 경우, 현재 잔과 바로 뒷잔을 마시는 경우, 현재 잔과 뒷뒷잔을 마시는 경우
        for(int i=4;i<=n;i++) {
            dp[i] = Math.max(Math.max(arr[i] + arr[i-1] + dp[i-3], arr[i] + dp[i-2]), dp[i-1]);
        }

        int answer = 0;
        for(int i=1;i<dp.length;i++) {
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
