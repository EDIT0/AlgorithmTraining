package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b3_24266 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            long n = Long.parseLong(br.readLine());

            bw.write(n*n*n + "\n");
            bw.write("3");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }
}
