package com.my.codingtest.baekjoon.silver;

import java.io.*;

public class s2_4948 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            while (true) {
                long n = Long.parseLong(br.readLine());
                if(n == 0) break;

                long start = n + 1;
                long end = 2 * n;

                long count =0;
                for(long i=start;i<=end;i++) {
                    if(isPrimeNumber(i)) {
                        count++;
                    }
                }
                bw.write(count + "\n");
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
            if(n % i == 0) return false;
        }

        return true;
    }
}
