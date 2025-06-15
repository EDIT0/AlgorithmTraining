package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 누적합_s5_2167 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int[][] arr;
    public static int[][] prefixArr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        prefixArr = new int[N+1][M+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=M;j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;
                prefixArr[i][j] = arr[i][j]
                        + prefixArr[i-1][j]
                        + prefixArr[i][j-1]
                        - prefixArr[i-1][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());

        for(int n=0;n<K;n++) {
            st = new StringTokenizer(br.readLine(), " ");

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = prefixArr[x][y]
                    - prefixArr[i-1][y]
                    - prefixArr[x][j-1]
                    + prefixArr[i-1][j-1];

            bw.write(result + "\n");
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                System.out.print(prefixArr[i][j] + " ");
            }
            System.out.println();
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
