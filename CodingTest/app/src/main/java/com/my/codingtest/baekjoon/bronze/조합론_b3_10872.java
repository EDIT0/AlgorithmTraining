package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

// 팩토리얼은 N개의 물건을 일렬로 나열하는 경우의 수
public class 조합론_b3_10872 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        bw.write(f(N) + "");
        bw.flush();
        bw.close();
        br.close();

    }

    public static int f(int n) {
        if(n <= 1) {
            return 1;
        }

        return n * f(n-1);
    }
}
