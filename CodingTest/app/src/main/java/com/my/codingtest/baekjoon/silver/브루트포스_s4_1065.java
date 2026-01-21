package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 브루트포스_s4_1065 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        if(N < 100) {
            answer = N;
        } else {
            answer = 99;
            for(int i=100;i<=N;i++) {
                boolean key = true;
                String s = String.valueOf(i);
                int a = Integer.parseInt(String.valueOf(s.charAt(0)));
                int b = Integer.parseInt(String.valueOf(s.charAt(1)));
                int same = b - a;
                for(int j=1;j<s.length();j++) {
                    int c = Integer.parseInt(String.valueOf(s.charAt(j))) - Integer.parseInt(String.valueOf(s.charAt(j-1)));
                    if(same != c) {
                        key = false;
                        break;
                    }
                }
                if(key) {
                   answer += 1;
                }
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
