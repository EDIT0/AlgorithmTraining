package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b3_24265 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());

            // 등차수열 합공식 1,2,3 ~ n = n(n+1)/2
            bw.write((long) ((long) (n-1)*n)/2 + "\n"); // n^2번 수행한다.
            bw.write("2"); // n^2번 돌기때문에 차수는 2

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
