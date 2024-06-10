package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b5_27323 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int A = Integer.parseInt(br.readLine());
            int B = Integer.parseInt(br.readLine());

            bw.write(A*B + "");

            br.close();
            bw.flush();
            bw.close();
        } catch (Exception e) {

        }
    }
}
