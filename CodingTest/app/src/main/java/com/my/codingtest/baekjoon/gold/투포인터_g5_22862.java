package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 투포인터_g5_22862 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N+1];

        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = 1;
        int max = 0;
        int currentK = 0;

        for(int i=1;i<=N;i++) {
            if(arr[i] % 2 != 0) {
                currentK += 1;
            }

            while(currentK > K) {
                if(arr[start] % 2 != 0) {
                    currentK -= 1;
                }
                start++;
            }

            int tmpMax = end - start + 1 - currentK;
            if(tmpMax > max) {
                max = tmpMax;
            }

            end += 1;
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
