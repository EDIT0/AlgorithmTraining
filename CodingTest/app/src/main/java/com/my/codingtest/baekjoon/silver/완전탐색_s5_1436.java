package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 완전탐색_s5_1436 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int number = 1;
        int count = 0;

        while (true) {
            if(String.valueOf(number).contains("666")) {
                count += 1;
                if(count == N) {
                    break;
                }
            }

            number += 1;
        }

        bw.write(number + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
