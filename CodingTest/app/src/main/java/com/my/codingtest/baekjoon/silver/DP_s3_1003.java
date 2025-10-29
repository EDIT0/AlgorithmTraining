package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class DP_s3_1003 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        int[] dp1 = new int[41];
        int[] dp2 = new int[41];

        dp1[0] = 1;
        dp1[1] = 0;
        dp2[0] = 0;
        dp2[1] = 1;

        for(int i=0;i<T;i++) {
            int n = Integer.parseInt(br.readLine());

            for(int j=2;j<=n;j++) {
                dp1[j] = dp1[j-1] + dp1[j-2];
                dp2[j] = dp2[j-1] + dp2[j-2];
            }

            bw.write(dp1[n] + " " + dp2[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
