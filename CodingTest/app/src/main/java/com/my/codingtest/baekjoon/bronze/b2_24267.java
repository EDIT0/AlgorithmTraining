package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b2_24267 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            long n = Long.parseLong(br.readLine());

            // 시그마 이용하여 공식 유도
            bw.write((n*(n-1)*(n-2))/6+ "\n");
            bw.write("3");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }
}