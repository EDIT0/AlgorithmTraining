package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b2_2292 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine()); // 입력 숫자
            int num = 1; // 입력 숫자에 따라 while문 반복을 멈추는 기준이 되는 숫자
            int idx = 1;

            // 1 + 6 * 1 = 7 -> 최소루트 2번째 까지의 리미트
            // 7 + 6 * 2 = 19 -> 최소루트 3번째 까지의 리미트
            // 19 + 6 * 3 = 37
            while (N > num) {
                num = (num + (6 * idx)); // 육각형
                idx++;
            }

            bw.write("" + idx);

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
