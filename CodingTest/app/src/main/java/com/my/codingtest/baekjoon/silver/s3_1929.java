package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s3_1929 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long M = Long.parseLong(st.nextToken());
            long N = Long.parseLong(st.nextToken());

            for(long i=M;i<=N;i++) {
                if(isPrimeNumber(i)) {
                    bw.write(i + "\n");
                }
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }

    public static boolean isPrimeNumber(long n) {
        if(n <= 1) return false;
        if(n <= 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;

        for(long i=4;i*i<=n;i++) {
            if(n%i == 0) {
                return false;
            }
        }

        return true;
    }
}
