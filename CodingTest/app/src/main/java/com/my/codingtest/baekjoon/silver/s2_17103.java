package com.my.codingtest.baekjoon.silver;

import java.io.*;

public class s2_17103 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int MAX = 1000000;
            Boolean[] arr = new Boolean[MAX + 1];
            arr[0] = false;
            arr[1] = false;
            for(int i=2;i<=MAX;i++) {
                arr[i] = isPrimeNumber(i);
            }

            int T = Integer.parseInt(br.readLine());

            for(int i=0;i<T;i++) {
                int N = Integer.parseInt(br.readLine());

                int repeatCount = N / 2;

                int tmpN = N - 2;
                int result = 0;

                for(int j=2;j<=repeatCount;j++) {
                    if(arr[j] && arr[tmpN]) {
                        result++;
                    }
                    tmpN--;
                }
                bw.write(result + "\n");
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
