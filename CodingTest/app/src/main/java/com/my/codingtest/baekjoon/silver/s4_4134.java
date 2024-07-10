package com.my.codingtest.baekjoon.silver;

import java.io.*;

public class s4_4134 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());

            long[] arr = new long[N];
            for(int i=0;i<N;i++) {
                arr[i] = Long.parseLong(br.readLine());
            }


            for(int i=0;i<N;i++) {
                long tmp = arr[i];

                while (true) {
                    if(isPrimeNumber(tmp)) {
                        break;
                    } else {
                        tmp++;
                    }
                }

                bw.write(tmp + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

    public static boolean isPrimeNumber(long n) {
        if (n <= 1) return false; // 1보다 작은면 소수x
        if (n <= 3) return true; // 2, 3은 소수o
        if (n % 2 == 0 || n % 3 == 0) return false; // 2나 3으로 나누어 떨어지면 소수x

        for (long i = 4; i * i <= n; i++) {
            if (n % i == 0) { // 나누어 떨어지는 숫자가 있으면 소수가 아님
                return false;
            }
        }

        return true;
    }
}
