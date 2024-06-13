package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b4_24263 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());

            bw.write(n + "\n"); // n번 수행한다.
            bw.write("1"); // n번 돌기때문에 차수는 1

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
