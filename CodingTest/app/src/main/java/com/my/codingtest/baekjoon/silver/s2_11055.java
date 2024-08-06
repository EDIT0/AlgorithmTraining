package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s2_11055 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> result = new ArrayList<>();

            for(int i=0;i<N;i++) {
               result.add(i, A[i]);
                for(int j=0;j<i;j++) {
//                    System.out.println("i: " + i + " / " + "Order -> " + j);
                    if(A[j] < A[i]) {
                        result.set(i, Math.max(result.get(i), result.get(j) + A[i]));
                    }
                }
//                System.out.println();
//                for(int k=0;k<result.size();k++) {
//                    System.out.print(result.get(k) + " ");
//                }
//                System.out.println();
            }

            Collections.sort(result);
            bw.write(result.get(result.size() - 1) + "");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }

}
