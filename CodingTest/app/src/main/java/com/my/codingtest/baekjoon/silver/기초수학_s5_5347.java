package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 기초수학_s5_5347 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write(lcm(a, b) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    // 최대공약수
    public static long gcd(long a, long b) {
        if(a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    // 최소공배수
    public static long lcm(long a, long b) {
        return  a * b / gcd(a, b);
    }
}
