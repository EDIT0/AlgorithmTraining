package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 이분탐색_s4_2776 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            int N = Integer.parseInt(br.readLine());
            int[] nArr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0;j<N;j++) {
                nArr[j] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());
            int[] mArr = new int[M];
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0;j<M;j++) {
                mArr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nArr);

            for(int j=0;j<M;j++) {
                int result = binary(nArr, mArr[j]);
                bw.write(result + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int binary(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == key) {
                return 1;
            } else if(arr[mid] > key) {
                high = mid - 1;
            } else if(arr[mid] < key) {
                low = mid + 1;
            }
        }

        return 0;
    }
}
