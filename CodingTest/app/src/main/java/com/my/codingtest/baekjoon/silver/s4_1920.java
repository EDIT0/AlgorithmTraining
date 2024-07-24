package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s4_1920 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arrA = new int[N];
            for(int i=0;i<N;i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrA);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++) {
                int a = Integer.parseInt(st.nextToken());
                bw.write(binarySearch(a, arrA) + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

    public static int binarySearch(int key, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if(arr[mid] == key) {
                return 1;
            } else if(arr[mid] > key) {
                end = mid - 1;
            } else if(arr[mid] < key) {
                start = mid + 1;
            }
        }

        return 0;
    }
}
