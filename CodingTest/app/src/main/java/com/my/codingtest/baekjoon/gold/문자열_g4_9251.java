package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 문자열_g4_9251 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String A = br.readLine();
        String B = br.readLine();

        String[] arrA = new String[A.length()];
        String[] arrB = new String[B.length()];

        for(int i=0;i<A.length();i++) {
            arrA[i] = String.valueOf(A.charAt(i));
        }
        for(int i=0;i<B.length();i++) {
            arrB[i] = String.valueOf(B.charAt(i));
        }

        int[][] dp = new int[arrA.length + 1][arrB.length + 1];

        // 문자열을 출력해야한다면 추가
        String[][] strDp = new String[arrA.length + 1][arrB.length + 1];
        for(int i=0;i<strDp.length;i++) {
            for(int j=0;j<strDp[0].length;j++) {
                strDp[i][j] = "";
            }
        }

        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                if(arrA[i-1].equals(arrB[j-1])) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    strDp[i][j] = strDp[i-1][j-1] + arrA[i-1]; // 문자열을 출력해야한다면 추가
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    // 문자열을 출력해야한다면 추가
                    if(strDp[i][j-1].length() > strDp[i-1][j].length()) {
                        strDp[i][j] = strDp[i][j-1];
                    } else if(strDp[i][j-1].length() < strDp[i-1][j].length()) {
                        strDp[i][j] = strDp[i-1][j];
                    } else {
                        strDp[i][j] = strDp[i][j-1];
                    }
                }
            }
        }

        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length;j++) {
                System.out.print(dp[i][j] + " / ");
                System.out.print(strDp[i][j] + " / ");
            }
            System.out.println();
        }

        bw.write(dp[arrA.length][arrB.length] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
