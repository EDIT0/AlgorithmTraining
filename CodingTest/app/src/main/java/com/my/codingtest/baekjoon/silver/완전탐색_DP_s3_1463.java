package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 완전탐색_DP_s3_1463 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        arr[0] = 0;
        arr[1] = 0;
        /**
         * X가 3으로 나누어 떨어지면, 3으로 나눈다.
         * X가 2로 나누어 떨어지면, 2로 나눈다.
         * 1을 뺀다.
         *
         * arr에 각 최소 연산 값을 저장해서 최종 N에 대한 최소 연산 값을 구한다.
         */
        for(int i=2;i<arr.length;i++) {
            arr[i] = arr[i-1] + 1;
            if(i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i/2] + 1);
            }
            if(i % 3 == 0 ){
                arr[i] = Math.min(arr[i], arr[i/3] + 1);
            }
        }

        bw.write(arr[N] + "");
        bw.flush();
        bw.close();
        br.close();
        
    }
}
