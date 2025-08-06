package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s4_11047 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1 - o2 > 0) {
                return -1;
            } else if(o1 == o2) {
                return 0;
            } else {
                return 1;
            }
        });

        int index = 0;
        int coinCount = 0;
        while (K != 0 && index < N) {
            coinCount += (K / arr[index]);
            K = K % arr[index];

            index += 1;
        }

        bw.write(coinCount + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
