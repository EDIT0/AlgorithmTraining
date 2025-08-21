package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 그리디_g5_21758 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N+1];
        int[] arrSum = new int[N+1];

        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arrSum[i] = arrSum[i-1] + arr[i];
        }

        int totalSum = arrSum[arrSum.length-1];
        int answer = 0;

        // 1
        for(int i=2;i<N;i++) {
            int a = totalSum - arr[1] - arr[i]; // 첫번째 벌
            int b = totalSum - arrSum[i]; // 두번째 벌

            int s = a + b;
//            System.out.print(s + " / ");
            answer = Math.max(answer, s);
//            System.out.println(answer + "");
        }

        // 2
        for(int i=2;i<=N-1;i++) {
            int a = totalSum - arr[N] - arr[i]; // 첫번째 벌
            int b = arrSum[i-1]; // 두번째 벌

            int s = a + b;
//            System.out.print(s + " / ");
            answer = Math.max(answer, s);
//            System.out.println(answer + "");
        }

        // 3
        for(int i=2;i<=N-1;i++) {
            int a = arrSum[i] - arr[1]; // 첫번째 벌
            int b = arrSum[N-1] - arrSum[i-1]; // 두번째 벌

            int s = a + b;
//            System.out.print(s + " / ");
            answer = Math.max(answer, s);
//            System.out.println(answer + "");
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
