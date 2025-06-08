package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 기초수학_s4_9613 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        long[] arr;
        long sum;

        for(int i=0;i<t;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            arr = new long[n];
            sum = 0;

            for(int j=0;j<n;j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=0;j<arr.length-1;j++) {
                for(int k=j+1;k<arr.length;k++) {
                    sum += gcd(arr[j], arr[k]);
                }
            }

            bw.write(sum + "\n");
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
}
