package com.my.codingtest.baekjoon.silver;

import java.io.*;

public class s5_1436 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int result = 665;
            int N = Integer.parseInt(br.readLine());
            int count = 0;

            while (count < N) {
                result++;
                if(String.valueOf(result).contains("666")) {
                    count++;
                }
            }

            bw.write(result + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
