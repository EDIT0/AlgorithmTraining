package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s5_13909 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            long N = Long.parseLong(br.readLine());

            int result = 0;

            // 약수로 구하면 다 시간초과 된다.

            for(int i=1;i*i<=N;i++) {
                result++;
            }

            bw.write(result + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

    // 약수 구하기 1.
    public static ArrayList<Long> divisor1(long N) {
        ArrayList<Long> longList = new ArrayList<>();
        for(long i=1;i<=Math.sqrt(N);i++) {
            if(N % i == 0) {
                longList.add(i);
            }
        }

        longList.add(N);

        return longList;
    }

    // 약수 구하기 2.
    public static ArrayList<Long> divisor(long n) {
        int sqrt = (int) Math.sqrt(n); // 100의 제곱근은 10
        ArrayList<Long> arr = new ArrayList<>(); // 약수 받을 ArrayList

        for(long i = 1; i <= sqrt; i++){
            if(n % i == 0){ // 약수 중 작은 수 저장
                arr.add(i);
                if(n / i != i){ // 약수 중 큰 수 저장
                    arr.add((n / i));
                }
            }
        }

        return arr;
    }
}
