package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

// 투 포인터 정렬
public class 투포인터_s5_11728 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[N];
        int[] arr2 = new int[M];
        int[] merge = new int[N+M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<M;i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int index1 = 0;
        int index2 = 0;
        int mergeIndex = 0;

        while (index1 < arr1.length && index2 < arr2.length) {
            int a = arr1[index1];
            int b = arr2[index2];

            int num = Math.min(a, b);

            if(num == a) {
                index1 += 1;
            } else if(num == b) {
                index2 += 1;
            }

            merge[mergeIndex] = num;

            mergeIndex += 1;
        }

        while (index1 < arr1.length) {
            merge[mergeIndex] = arr1[index1];
            index1 += 1;
            mergeIndex += 1;
        }

        while (index2 < arr2.length) {
            merge[mergeIndex] = arr2[index2];
            index2 += 1;
            mergeIndex += 1;
        }

        for(int i=0;i<merge.length;i++) {
            bw.write(merge[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
