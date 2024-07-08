package com.my.codingtest.test;

import java.io.*;
import java.util.*;

public class euclidean_1 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 36
            int b = Integer.parseInt(st.nextToken()); // 24

            bw.write("최대 공약수: " + gdc(a, b) + "\n");
            bw.write("최소 공배수: " + lcm(a, b) + "\n");

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
