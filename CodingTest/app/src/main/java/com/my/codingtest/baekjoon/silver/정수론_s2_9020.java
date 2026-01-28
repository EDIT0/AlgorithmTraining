package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 정수론_s2_9020 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static boolean[] check = new boolean[10001];

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int i=1;i<=10000;i++) {
            check[i] = isPrime(i);
        }

        for(int i=0;i<T;i++) {
            int n = Integer.parseInt(br.readLine());
            int a = 0;
            int b = 0;
            for(int j=n;j>=n/2;j--) {
                if(check[j]) {
                    int e = n - j;
                    if(check[e]) {
                        a = e;
                        b = j;
                    }
                }
            }
            bw.write(a + " " + b + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 에라토스테네스의 체
    public static boolean isPrime(int n){
        if(n < 2){
            return false;
        } else{
            for(int i=2;i<n;i++){
                if(n%i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
