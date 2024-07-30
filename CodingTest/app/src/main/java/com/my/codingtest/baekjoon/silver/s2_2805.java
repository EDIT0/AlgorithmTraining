package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s2_2805 {
    public static void main(String[] args) {

        // 100,000,000

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            long result = binary1(M, arr);

            bw.write(result + "\n");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }

    public static long binary1(int key, int[] arr) {
        long start = 1;
        long end = arr[arr.length - 1];
        long mid;

        long result = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            long sum = 0;
            for(int i=0;i<arr.length;i++) {
                long tmp = (arr[i] - mid);
                if(tmp > 0) {
                    sum += tmp;
                }
            }

            if(sum == key) {
                result = mid;
                start = mid + 1;
            } else if(sum < key) {
                end = mid - 1;
            } else if(sum > key) {
                result = mid;
                start = mid + 1;
            }
        }

        return result;
    }
}
