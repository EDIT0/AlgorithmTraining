package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 기초수학_s1_1747 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        while (true) {
            String strN = String.valueOf(N);

            int index = strN.length() - 1;
            boolean isFlag = true;
            for(int i=0;i<strN.length()/2;i++) {
                if(strN.charAt(i) - strN.charAt(index - i) == 0) {

                } else {
                    isFlag = false;
                    break;
                }
            }

            if(isFlag && primeNumber(N)) {
                bw.write(N + "");
                break;
            }

            N += 1;
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static boolean primeNumber(int n) {
        if(n < 2) {
            return false;
        }

        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
