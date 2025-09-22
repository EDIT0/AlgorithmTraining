package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 완전탐색_DP_s3_11727 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        if(n >= 1) {
            arr[1] = 1;
        }

        if(n >= 2) {
            arr[2] = 3;
        }

        // i-1 에서 오는 경우: 마지막에 세로 2칸(2x1) 타일을 놓음
        // i-2 에서 오는 경우: 1x2 가로 타일 2개를 놓는 방법, 2x2 정사각형을 놓는 방법
        for(int i=3;i<=n;i++) {
            arr[i] = (arr[i-1] + arr[i-2] + arr[i-2]) % 10007;
        }

        bw.write(arr[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
