package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b3_2903 {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            int rectangleCount = 1; // 초기 사각형 수
            int pointCount = 4; // 초기 꼭지점 수

            // 꼭지점 갯수 구하기 (2^n + 1)^2
            for(int i=1;i<=N;i++) {
                rectangleCount = rectangleCount * 4;
                pointCount = (int) Math.pow((Math.pow(2, i) + 1), 2);
            }
            bw.write("" + pointCount);

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }

    }
}
