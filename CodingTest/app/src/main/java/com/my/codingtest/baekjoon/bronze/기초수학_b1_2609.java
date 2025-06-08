package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 기초수학_b1_2609 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(gcd(a, b) + "\n" + lcm(a, b));

        bw.flush();
        bw.close();
        br.close();
    }

    // 최대 공약수
    public static long gcd(long a, long b) {
        if(a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        while(b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    // 최소 공배수
    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
