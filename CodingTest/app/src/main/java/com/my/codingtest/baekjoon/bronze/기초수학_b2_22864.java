package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 기초수학_b2_22864 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken()); // 피로도 업
        int B = Integer.parseInt(st.nextToken()); // 일
        int C = Integer.parseInt(st.nextToken()); // 피로도 다운
        int M = Integer.parseInt(st.nextToken()); // 최대 피로도

        int hour = 0;
        int current = 0;
        int work = 0;

        while (hour < 24) {
            hour += 1;

            if(current <= (M-A)) {
                current += A;
                work += B;
            } else if(current > (M-A)) {
                current -= C;
            }

            if(current < 0) {
                current = 0;
            }
        }

        bw.write(work + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
