package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 누적합_s5_14929 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long totalSum = 0;
        for(int i=0;i<N;i++) {
            totalSum += arr[i];
        }

        long answer = 0;
        for(int i=0;i<N;i++) {
            totalSum -= arr[i]; // arr[i]을 뺀 후
            answer += (arr[i] * totalSum); // arr[i] * 나머지들에 대한 합을 더해준다.
        }

        bw.write(answer + "");
//        long sum = 0;
//        for(int i=0;i<arr.length;i++) {
//            for(int j=i+1;j<arr.length;j++) {
//                sum += (arr[i] * arr[j]);
//            }
//        }

//        bw.write(sum + "");

        bw.flush();
        bw.close();
        br.close();

    }

}
