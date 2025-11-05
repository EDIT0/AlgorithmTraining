package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s4_2217 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1 > o2) {
                return -1;
            } else if(o1 < o2) {
                return 1;
            } else {
                return 0;
            }
        });

        int answer = 0;
        for(int i=0;i<N;i++) {
            answer = Math.max(answer, arr[i] * (i+1));
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
