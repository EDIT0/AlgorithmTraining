package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s5_14916 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        while (n >= 0 && n % 5 != 0) {
            n -= 2;
            count += 1;
        }

        if(n >= 0) {
            count += (n / 5);
        } else {
            count = -1;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
