package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s5_13241 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            bw.write(lcm(A, B) + "");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }

    // 최대 공약수
    public static long gdc(long a, long b) {
        if(a < b) { // 유클리드 호제법 조건
            long tmp = a;
            a = b;
            b = tmp;
        }
        while(b != 0) { // 유클리드 호제법
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소 공배수
    public static long lcm(long a, long b) {
        return a * b / gdc(a, b);
    }
}
