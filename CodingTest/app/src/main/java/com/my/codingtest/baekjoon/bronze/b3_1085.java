package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b3_1085 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            int i = 0;
            int j = 0;

            int answerX = Math.min(x-i, w-x); // x축에서 가장 거리가 짧은 값
            int answerY = Math.min(y-j, h-y); // y축에서 가장 거리가 짧은 값

            int answer = Math.min(answerX, answerY); // x, y 축 중 더 짧은 값

            bw.write(answer + "");

            br.close();
            bw.flush();
            bw.close();
        } catch (Exception e) {

        }
    }
}
