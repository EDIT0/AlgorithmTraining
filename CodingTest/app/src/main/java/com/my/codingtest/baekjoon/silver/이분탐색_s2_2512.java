package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 이분탐색_s2_2512 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        int totalSum = 0;
        long answer = 0;
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            totalSum += arr[i];
        }

        int M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

//        if(totalSum > M) {
            answer = binary(arr, M);
//        } else {
//            answer = arr[arr.length - 1];
//        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static long binary(int[] arr, int M) {
        int low = 0;
        int high = arr[arr.length-1];
        long returnValue = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            long sum = 0;
            for (int i=0;i<arr.length;i++) {
                sum += Math.min(arr[i], mid);
            }

            if(sum <= M) {
                low = mid + 1;
                returnValue = mid;
            } else if(sum > M) {
                high = mid - 1;
            }

        }

        return returnValue;
    }
}
