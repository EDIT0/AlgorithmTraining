package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 기초수학_b2_2581 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int sum = 0;
    public static int least = 0;

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        for(int i=M;i<=N;i++) {
            boolean flag = cal(i);
            if(flag) {
                if(least == 0) {
                    least = i;
                }
                sum += i;
            }
        }

        if(least == 0 && sum == 0) {
            bw.write("-1");
        } else {
            bw.write(sum + "\n" + least);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean cal(int n) {
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
