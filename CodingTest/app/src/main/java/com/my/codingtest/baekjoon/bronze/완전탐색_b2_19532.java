package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 완전탐색_b2_19532 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        for(int i=-999;i<=999;i++) {
            for(int j=-999;j<=999;j++) {
                if((x1*i + y1*j) == c1 && (x2*i + y2*j) == c2) {
                    bw.write(i + " " + j);
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
