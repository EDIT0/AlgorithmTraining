package com.my.codingtest.baekjoon.silver;

import java.io.*;

public class s4_2485 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int minValue = 0;
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(br.readLine());
                if(i > 0) {
                    int middle = arr[i] - arr[i-1]; // 중간 거리
                    minValue = gdc(middle, minValue); // 중간 거리와 midValue의 최대 공약수를 구한다.
                }
            }

            int result = (arr[arr.length - 1] - arr[0]) / minValue - (arr.length - 1);
            bw.write(result + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

    // 최대 공약수
    public static int gdc(int a, int b) {
        if(a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    // 최소 공배수
    public static int lcm(int a, int b) {
        return a * b / gdc(a, b);
    }
}
