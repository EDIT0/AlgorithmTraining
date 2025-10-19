package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 조합론_b4_24723 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        answer = (int) Math.pow(2, N);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
