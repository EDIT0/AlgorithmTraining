package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 이분탐색_s1_2343 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = binary(arr, M);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int binary(int[] arr, int M) {
        int low = 0;
        int high = 0;
        for(int i=0;i<arr.length;i++) {
            high += arr[i];
            low = Math.max(low, arr[i]);
        }
        int returnValue = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            int count = 1;
            int sum = 0;
            for(int i=0;i<arr.length;i++) {
                int s = sum + arr[i];
                if(s > mid) {
//                    System.out.println("init: " + s);
                    count += 1;
                    sum = 0;
                }
                sum += arr[i];
//                System.out.println("sum: " + sum);
            }

            if(count <= M) {
                System.out.println("count: " + count);
                high = mid - 1;
                returnValue = mid;
            } else if(count > M) {
                low = mid + 1;
            }
        }

        return returnValue;
    }

}
