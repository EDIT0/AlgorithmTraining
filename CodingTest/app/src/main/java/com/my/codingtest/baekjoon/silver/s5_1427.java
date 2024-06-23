package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s5_1427 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            int length = String.valueOf(N).length();
            Integer[] arr = new Integer[length];
            for(int i=0;i<length;i++) {
                arr[i] = N % 10;
                N/=10;
            }

            Arrays.sort(arr, Collections.reverseOrder());

            for(int i=0;i<length;i++) {
                bw.write(arr[i] + "");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
