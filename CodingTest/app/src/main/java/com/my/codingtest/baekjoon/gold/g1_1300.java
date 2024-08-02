package com.my.codingtest.baekjoon.gold;

import java.io.*;

public class g1_1300 {
    public static void main(String[] args) {

        // 200,000,000

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            bw.write(binary1(k, N) + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

    public static long binary1(int key, int N) {
        long start = 1;
        long end = (long) N * N;
        long mid;

        long result = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            long sum = 0;
            for(int i=1;i<=N;i++) {
                long tmp = (mid / i);
                if(tmp > N) { // tmp 값이 N보다 크면 N을 넣는다.
                    tmp = N;
                }
                sum += tmp;
            }

            if(sum == key) {
                result = mid;
                end = mid - 1;
            } else if(sum < key) {
                start = mid + 1;
            } else if(sum > key) {
                result = mid;
                end = mid - 1;
            }
        }

        return result;
    }
}
