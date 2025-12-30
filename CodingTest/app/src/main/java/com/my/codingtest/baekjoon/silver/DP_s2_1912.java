package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class DP_s2_1912 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
        }

        int answer = -1001;
        for(int i=1;i<=n;i++) {
            answer = Math.max(dp[i], answer);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }
}
