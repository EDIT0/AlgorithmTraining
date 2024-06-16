package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class b2_19532 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            for(int i=-999;i<=999;i++) {
                for(int j=-999;j<=999;j++) {
                    if(((a*i) + (b*j) == c) && ((d*i) + (e*j) == f)) {
                        bw.write(i + " " + j);
                        break;
                    }
                }
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
