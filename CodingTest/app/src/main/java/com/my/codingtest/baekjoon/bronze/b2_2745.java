package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b2_2745 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String N = st.nextToken();
            int B = Integer.parseInt(st.nextToken());
            int sum = 0;
            int idx = 0;

            for (int i=N.length()-1;i>=0;i--) {
                char c = N.charAt(i);
                int num = 0;
                if ('A' <= c && c <= 'Z') {
                    num = c - 'A' + 10; // A=10, B=11 ... Z=35
                    System.out.println("1. " + num);
                } else {
                    num = c - '0'; // 0=0, 1=1 ... 9=9
                    System.out.println("2. " + c + "-" + '0' + "=" + num);
                }
//                sum = sum * B + num;
                sum += (num * Math.pow(B, idx++));
                System.out.println(sum + " / " + num*Math.pow(B, idx++) + " / " + num + " / " + Math.pow(B, idx) + " / " + B + " / " + i + " / " + idx);
            }

            bw.write(String.valueOf(sum));

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }

    }
}
