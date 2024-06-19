package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class b2_2750 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);

            for(int i=0;i<arr.length;i++) {
                bw.write(arr[i] + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
