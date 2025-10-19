package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

// 이항 계수는 N개의 물건 중 K개를 순서 없이 고르는 경우의 수
public class 조합론_b1_11050 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bw.write(binomialEfficient(N, K) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    // nCk
    public static int binomialEfficient(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n-k));
    }

    public static int factorial(int n) {
        if(n <= 1) {
            return 1;
        }

        return n * factorial(n-1);
    }
}
