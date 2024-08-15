package com.my.codingtest.baekjoon.bronze;

import java.io.*;

public class b1_24416 {

    static int fib1Result = 0;
    static int fib2Result = 0;

    static int[] arr;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];

            fib1(n);
            fib2(n);


            bw.write(fib1Result + " " + fib2Result);

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

    public static int fib1(int n) {
        if(n == 1 || n == 2) {
            fib1Result++;
            return 1;
        } else {
            return fib1(n-1) + fib1(n-2);
        }
    }

    public static int fib2(int n) {
        arr[0] = 1;
        arr[1] = 1;

        for(int i=2;i<n;i++) {
            fib2Result++;
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n-1];
    }
}
