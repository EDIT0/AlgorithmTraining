package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s2_11722 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];

            int[] result = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            // 증가하는 것처럼 반대부터 시작해도 된다.
//            for(int i=N-1;i>=0;i--) {
//                result[i] = 0;
//                for(int j=N-1;j>i;j--) {
//                    if(A[j] < A[i]) {
//                        result[i] = Math.max(result[i], result[j] + 1);
//                    }
//                }
//            }
//
//            Arrays.sort(result);
//
//            bw.write(result[result.length - 1] + 1 + "");

            for(int i=0;i<N;i++) {
                result[i] = 0;
                for (int j=0;j<i;j++) {
                    if (A[j] > A[i]) {
                        result[i] = Math.max(result[i], result[j] + 1);
                    }
                }
            }

            Arrays.sort(result);

            bw.write(result[result.length - 1] + 1 + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
