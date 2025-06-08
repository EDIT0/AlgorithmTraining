package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 기초수학_s4_2960 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] isDeleted = new boolean[N+1];

        int c = 2;
        int cycle = 0;
        boolean isFlag = true;
        while (isFlag) {
            int t = N/c;
            if(t != 0) {
                t += 1;
            }
            for(int i=1;i<t;i++) {
                int value = c * i;
                if(!isDeleted[value]) {
                    cycle += 1;
                    isDeleted[value] = true;
                    if(cycle == K) {
                        bw.write(value + "");
                        isFlag = false;
                        break;
                    }
                }
            }
            c += 1;
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
