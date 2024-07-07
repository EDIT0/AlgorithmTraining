package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s4_1269 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] arrA = new int[A];
            Map<Integer, Integer> hashMapA = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<A;i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
                hashMapA.put(arrA[i], 0);
            }

            int[] arrB = new int[B];
            Map<Integer, Integer> hashMapB = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<B;i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
                hashMapB.put(arrB[i], 0);
            }

            // 대칭 차집합 A - B, B - A 두 집합을 합친 것

            int count = 0;

            // A - B
            for(int i=0;i<B;i++) {
                if(!hashMapA.containsKey(arrB[i])) { // A에 B의 값이 포함되어 있지 않은 만큼 +
                    count++;
                }
            }

            // B - A
            for(int i=0;i<A;i++) {
                if(!hashMapB.containsKey(arrA[i])) { // B에 A의 값이 포함되어 있지 않은 만큼 +
                    count++;
                }
            }

            bw.write(count + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

}
