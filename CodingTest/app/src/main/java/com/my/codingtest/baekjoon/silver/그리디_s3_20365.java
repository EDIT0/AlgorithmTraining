package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s3_20365 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String inputString = br.readLine();

        // B, R, BBBBBB, R
        // BB R B R BB R / 4

        String[] arr = new String[inputString.length()];
        for(int i=0;i<arr.length;i++) {
            arr[i] = String.valueOf(inputString.charAt(i));
        }

        int countB = 0;
        int countR = 0;
        String prev = ".";
        for(int i=0;i<arr.length;i++) {
            if(!prev.equals(arr[i])) {
                if(arr[i].equals("R")) {
                    countR += 1;
                } else if(arr[i].equals("B")) {
                    countB += 1;
                }
                prev = arr[i];
            }
        }

        bw.write(Math.min(countB, countR) + 1 + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
