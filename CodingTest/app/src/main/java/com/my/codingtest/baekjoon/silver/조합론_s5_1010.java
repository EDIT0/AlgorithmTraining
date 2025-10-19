package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 조합론_s5_1010 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M= Integer.parseInt(st.nextToken());

            bw.write(binominalEfficient(M, N) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static long binominalEfficient(int n, int m) {
        // 29, 13
        // 29! / (13! * 16!)
        // 5, 1
        // 5! / (1! * 4!)

        int s = n-m;
        long result = 1;
        for(int i=1;i<=m;i++) {
            result = result * (s+i) / i;
        }

        return result;
    }

    public static long factorial(int n) {
        if(n <= 1) {
            return 1;
        }

        return n * factorial(n-1);
    }
}
