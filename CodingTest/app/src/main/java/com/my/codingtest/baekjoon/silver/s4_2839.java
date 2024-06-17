package com.my.codingtest.baekjoon.silver;

import java.io.*;

public class s4_2839 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            int result = -1;

            if(N == 4 || N == 7) {
                result = -1;
            } else if(N % 5 == 0) {
                result = N / 5;
            } else if(N % 5 == 1 || N % 5 == 3) {
                result = N / 5 + 1;
            } else if(N % 5 == 2 || N % 5 == 4) {
                result = N / 5 + 2;
            }

            bw.write(result + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
