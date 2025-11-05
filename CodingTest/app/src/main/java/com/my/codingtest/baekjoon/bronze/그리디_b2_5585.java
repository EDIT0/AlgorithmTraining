package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 그리디_b2_5585 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int change = 1000 - n;
        int answer = 0;

        int[] coin = {500, 100, 50, 10, 5, 1};

        for(int i=0;i<coin.length;i++) {
            answer += (change / coin[i]);
            change = change % coin[i];
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
