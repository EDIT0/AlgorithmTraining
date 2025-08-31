package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

// 완전탐색
public class 구현_s2_3085 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N = 0;
    public static char[][] arr;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<str.length();j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        // 초기 상태 검사
        checkRow(arr);
        checkColumn(arr);

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(j+1 < N) {
                    swap(i, j, i, j+1);
                    checkRow(arr);
                    checkColumn(arr);
                    swap(i, j, i, j+1);
                }
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(i+1 < N) {
                    swap(i, j, i+1, j);
                    checkRow(arr);
                    checkColumn(arr);
                    swap(i, j, i+1, j);
                }
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }

    public static void checkRow(char[][] arr) {
        for(int i=0;i<N;i++) {
            int cnt = 1;
            for (int j=1;j<N;j++) {
                if (arr[i][j] == arr[i][j-1]) {
                    cnt++;
                    answer = Math.max(answer, cnt);
                } else {
                    cnt = 1;
                }
            }
        }
    }

    public static void checkColumn(char[][] arr) {
        for(int i=0;i<N;i++) {
            int cnt = 1;
            for (int j=1;j<N;j++) {
                if (arr[j][i] == arr[j-1][i]) {
                    cnt++;
                    answer = Math.max(answer, cnt);
                } else {
                    cnt = 1;
                }
            }
        }
    }
}
