package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

// 투 포인터 합
public class 투포인터_s4_1940 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int answer = 0;

        while (left < right) {
            int n = arr[left] + arr[right];
            if(n == M) {
                answer += 1;
                left += 1;
                right -= 1;
            } else if(n < M) {
                left += 1;
            } else if(n > M) {
                right -= 1;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
