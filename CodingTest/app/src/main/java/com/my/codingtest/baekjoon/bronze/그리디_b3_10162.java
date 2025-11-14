package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 그리디_b3_10162 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // 5분, 1분, 10초
        int T = Integer.parseInt(br.readLine());

        int A = 300;
        int B = 60;
        int C = 10;

        int aCount = 0;
        aCount = T / A;
        T = T % A;

        int bCount = 0;
        bCount = T / B;
        T = T % B;

        int cCount = 0;
        cCount = T / C;
        T = T % C;

        if(T == 0) {
            bw.write(aCount + " " + bCount + " " + cCount);
        } else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
