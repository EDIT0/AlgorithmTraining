package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s4_2847 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        int nextLevel = Integer.MAX_VALUE;
        for(int i=arr.length-1;i>=0;i--) {
            if(arr[i] < nextLevel) {

            } else {
                answer += Math.abs(nextLevel - arr[i] - 1);
                arr[i] = nextLevel - 1;
            }

            nextLevel = arr[i];
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
