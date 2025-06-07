package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 기초수학_b2_1978 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int count = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(st.nextToken());

            if(num == 1) {
                continue;
            }

            boolean isFlag = true;
            for(int j=2;j<=num/2;j++) {
                if(num % j == 0) {
                    isFlag = false;
                    break;
                }
            }
            if(isFlag) {
                count += 1;
            }
        }

        bw.write(count + "");
        bw.close();
        br.close();
    }
}
