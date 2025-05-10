package com.my.codingtest.baekjoon.bronze;

import java.io.*;

public class 문자열_b4_11720 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int numberCount = Integer.parseInt(br.readLine());
            String numbers = br.readLine();

            int sum = 0;

            for(int i=0;i<numberCount;i++) {
                sum += Integer.parseInt(String.valueOf(numbers.charAt(i)));
            }

            bw.write(sum + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
