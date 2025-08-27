package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

// DP
public class 구현_s3_14501 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][2];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+2];
        for(int i=N;i>0;i--) {
            if(i+arr[i][0] <= N+1) { // 일과 걸리는 날에 따라 상담 가능한지 여부 판단
                dp[i] = Math.max(dp[i+1], arr[i][1] + dp[i+arr[i][0]]);
                System.out.println("1. 상담함 " + i + " / " + dp[i] + " / " + dp[i+1] + " / " +  arr[i][1] + " / " + dp[i+arr[i][0]]);
            } else {
                dp[i] = dp[i+1];
                System.out.println("2. 상담안함 " + i + " / " + dp[i]);
            }
        }

        int answer = 0;
        for(int i=0;i<dp.length;i++) {
            System.out.println(i + "일차 " + dp[i] + "");
            if(dp[i] > answer) {
                answer = dp[i];
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
