package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 기초수학_s4_21920 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        long N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        long X = Integer.parseInt(br.readLine());

        long sum = 0;
        long index = 0;

        for(int i=0;i<N;i++) {
            long n = Integer.parseInt(st.nextToken());
            long r = gcd(n, X);
            if(r == 1) {
                sum += n;
                index += 1;
            }
        }

        bw.write((sum / (double)index) + "");

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
}
