package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s3_20300 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Long[] arr = new Long[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        // 1, 2, 3, 4, 5
        Arrays.sort(arr, (o1, o2) -> {
            if(o1 - o2 > 0) {
                return 1;
            } else if(o1 == o2) {
                return 0;
            } else {
                return -1;
            }
        });

        int start = 0;
        int end = arr.length - 1;
        long max = 0;

        // 갯수가 짝수인지 홀수인지 확인
        if(arr.length % 2 != 0) {
            end = arr.length - 2;
        }

        while (start < end) {
            long sum = arr[start] + arr[end];
            if(sum > max) {
                max = sum;
            }
            start += 1;
            end -= 1;
        }

        // 갯수가 짝수인지 홀수인지 확인
        if(arr.length % 2 != 0) {
            max = Math.max(max, arr[arr.length-1]);
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
