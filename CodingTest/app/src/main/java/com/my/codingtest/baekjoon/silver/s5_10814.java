package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s5_10814 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            String[][] arrStr = new String[N][2];

            StringTokenizer st;
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                arrStr[i][0] = String.valueOf(st.nextToken());
                arrStr[i][1] = String.valueOf(st.nextToken());
            }

            Arrays.sort(arrStr, (o1, o2) -> {
                if(Integer.parseInt(o1[0]) != Integer.parseInt(o2[0])) {
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                } else {
                    return 0; // -1, 0, 1
                }
            });

            for(int i=0;i<N;i++) {
                bw.write(arrStr[i][0] + " " + arrStr[i][1] + "\n");
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }
}
