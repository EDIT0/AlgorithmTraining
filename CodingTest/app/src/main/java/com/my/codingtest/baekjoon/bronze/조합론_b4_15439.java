package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 조합론_b4_15439 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=0;i<N;i++) {
            // 상의 선택 횟수 N번 반복
            answer += (N-1); // 상의 1번 당 하의 N-1번 조합 가능
        }
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
