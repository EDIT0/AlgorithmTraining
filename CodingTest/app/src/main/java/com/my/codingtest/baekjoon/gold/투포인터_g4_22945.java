package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 투포인터_g4_22945 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N+1];

        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = N;
        int maxAbility = Integer.MIN_VALUE;

        while (start < end) {
            int p = end - start - 1;

            int a = p * Math.min(arr[start], arr[end]);

            if(a > maxAbility) {
                maxAbility = a;
            }

            if(arr[start] < arr[end]) {
                start += 1;
            } else {
                end -= 1;
            }
        }

        bw.write(maxAbility + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
