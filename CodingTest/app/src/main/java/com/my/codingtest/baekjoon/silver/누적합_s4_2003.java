package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 누적합_s4_2003 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /**
         * 4 2
         * 1 1 1 1
         *
         * 3
         * (1,2) (2,3) (3,4)
         * -
         *
         * 10 5
         * 1 2 3 4 2 5 3 1 1 2
         *
         * 3
         * (2,3) (6,6) (7,9)
         * */

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        int answer = twoPointer(arr, N, M);
        int answer = prefixSum(arr, N, M);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int prefixSum(int[] arr, int N, int M) {
        int[] prefix = new int[N+1];
        for(int i=1;i<=N;i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        int answer = 0;

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                int sum = prefix[j] - prefix[i-1];
                if(sum == M) {
                    answer += 1;
                }
            }
        }

        return answer;
    }

    public static int twoPointer(int[] arr, int N, int M) {
        int start = 1;
        int end = 1;
        int sum = arr[1];
        int answer = 0;

        while (start <= N) {
            if(sum == M) {
                answer += 1;
                sum -= arr[start];
                start += 1;
            } else if(sum < M) {
                end += 1;
                if(end > N) {
                    break;
                }
                sum += arr[end];
            } else if(sum > M) {
                sum -= arr[start];
                start += 1;
            }
        }

        return answer;
    }
}
