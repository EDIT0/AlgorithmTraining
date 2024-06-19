package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class b2_2587 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = 5;
            int[] arr = new int[n];
            int sum = 0;
            for(int i=0;i<n;i++) {
                arr[i] = Integer.parseInt(br.readLine());
                sum += arr[i];
            }

            Arrays.sort(arr);

            bw.write(sum/n + "\n" + arr[n/2]);

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
