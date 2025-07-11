package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 누적합_s1_11660 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=1;j<=N;j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n + arr[i][j-1] + arr[i-1][j] - arr[i-1][j-1];
            }
        }

//        for(int i=1;i<=N;i++) {
//            for(int j=1;j<=N;j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int answer = arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1];
            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
