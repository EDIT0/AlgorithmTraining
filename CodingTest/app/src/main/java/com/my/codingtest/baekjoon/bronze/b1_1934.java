package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class b1_1934 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int T = Integer.parseInt(br.readLine());

            StringTokenizer st;

            for(int i=0;i<T;i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                // 유클리드 호제법
                bw.write(lcm(A, B) + "\n");

                // 단순 방식
//                int repeat = 1;
//                while (true) {
//                    if((A * repeat) % B == 0) {
//                        bw.write(A * repeat + "\n");
//                        break;
//                    }
//                    repeat++;
//                }
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

    // 최대 공약수
    public static int gdc(int a, int b) {
        if(a < b) { // 유클리드 호제법 조건
            int tmp = a;
            a = b;
            b = tmp;
        }
        while(b != 0) { // 유클리드 호제법
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소 공배수
    public static int lcm(int a, int b) {
        return a * b / gdc(a, b);
    }
}