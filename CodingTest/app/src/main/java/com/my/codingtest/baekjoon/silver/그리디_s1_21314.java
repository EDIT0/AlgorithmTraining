package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s1_21314 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        StringBuilder maxSb = new StringBuilder();
        StringBuilder minSb = new StringBuilder();

        int count = 0;

        for(int i=0;i<input.length();i++) {
            char c = input.charAt(i);
            if(c == 'M') {
                count += 1;
            } else {
                maxSb.append("5");
                for(int j=0;j<count;j++) {
                    maxSb.append("0");
                }

                if(count > 0) {
                    minSb.append("1");
                    for(int j=0;j<count-1;j++) {
                        minSb.append("0");
                    }
                    minSb.append("5");
                } else {
                    minSb.append("5");
                }
                count = 0;
            }
        }

        for(int i=0;i<count;i++) {
            maxSb.append("1");
            if(i == 0) {
                minSb.append("1");
            } else {
                minSb.append("0");
            }
        }

        bw.write(maxSb + "\n" + minSb);
        bw.flush();
        bw.close();
        br.close();
    }

}
