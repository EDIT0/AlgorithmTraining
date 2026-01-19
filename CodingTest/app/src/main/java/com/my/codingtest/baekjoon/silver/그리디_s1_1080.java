package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s1_1080 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[N][M];
        int[][] arr2 = new int[N][M];


        for(int i=0;i<N;i++) {
            String input = br.readLine();
            for(int j=0;j<M;j++) {
                arr1[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }
        for(int i=0;i<N;i++) {
            String input = br.readLine();
            for(int j=0;j<M;j++) {
                arr2[i][j] = Integer.parseInt(String.valueOf(input.charAt(j)));
            }
        }

        int answer = 0;
        for(int i=0;i<=N-3;i++) {
            for(int j=0;j<=M-3;j++) {
                if(arr1[i][j] != arr2[i][j]) {
                    for(int k=i;k<i+3;k++) {
                        for(int h=j;h<j+3;h++) {
                            if(arr1[k][h] == 0) {
                                arr1[k][h] = 1;
                            } else {
                                arr1[k][h] = 0;
                            }
                        }
                    }
                    answer += 1;
                }
            }
        }

        boolean isSame = true;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(arr1[i][j] != arr2[i][j]) {
                    isSame = false;
                    break;
                }
            }
            if(!isSame) break;
        }

        bw.write(String.valueOf(isSame ? answer : -1));
        bw.flush();
        bw.close();
        br.close();
    }
}
