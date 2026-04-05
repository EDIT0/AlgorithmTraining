package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 완전탐색_DP_g5_9251 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String inputStr1 = br.readLine();
        String inputStr2 = br.readLine();

        int length1 = inputStr1.length();
        int length2 = inputStr2.length();

        char[] cArr1 = new char[length1 + 1];
        for(int i=1;i<=length1;i++) {
            cArr1[i] = inputStr1.charAt(i-1);
        }
        char[] cArr2 = new char[length2 + 1];
        for(int i=1;i<=length2;i++) {
            cArr2[i] = inputStr2.charAt(i-1);
        }

        /**
         * ACAYKP
         * CAPCAK
         *
         * ACAK
         * */
        int[][] dp = new int[length1 + 1][length2 + 1];
        for(int i=1;i<cArr1.length;i++) {
            for(int j=1;j<cArr2.length;j++) {
                if(cArr1[i-1] == cArr2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        for(int i=1;i<cArr1.length;i++) {
            for(int j=1;j<cArr2.length;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
