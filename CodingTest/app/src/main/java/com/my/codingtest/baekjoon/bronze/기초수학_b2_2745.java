package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 기초수학_b2_2745 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int index = N.length() - 1;
        int sum = 0;
        for(int i=0;i<N.length();i++) {
            char c = N.charAt(i);

            if(c >= 'A' && c <= 'Z') {
                int n = c - 55;
                sum += (int) (n * Math.pow(B, index));
            } else {
                int n = c - 48;
                sum += (int) (n * Math.pow(B, index));
            }

            index -= 1;
        }

        bw.write(sum + "");
        bw.close();
        br.close();
    }

}
