package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 완전탐색_DP_s3_11726 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        // 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

        int[] arr = new int[n+1];

        arr[0] = 0;
        if(n >= 1) {
            arr[1] = 1;
        }

        if(n >= 2) {
            arr[2] = 2;
        }

        if(n >= 3) {
            for(int i=3;i<=n;i++) {
                arr[i] = (arr[i-1] + arr[i-2]) % 10007;
            }
        }

        int answer = arr[n];

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
