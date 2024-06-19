package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class b2_25305 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Integer[] arr = new Integer[N];
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, Collections.reverseOrder()); // 내림차순

            bw.write(arr[k-1] + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
