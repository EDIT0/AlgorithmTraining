package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

// 완전탐색
public class 구현_s1_2615 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int[][] arr = new int[20][20];

        // 4방향 정의
        int[] dx = {0, 1, 1, -1};   // →, ↘, ↓, ↗
        int[] dy = {1, 1, 0, 1};

        for(int i=1;i<=19;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=19;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=19;i++) {
            for(int j=1;j<=19;j++) {
                int n = arr[i][j];

                if(n == 0) {
                    continue;
                }

                for(int k=0;k<4;k++) {
                    int count = 1;
                    int x = i + dx[k];
                    int y = j + dy[k];

                    while (x >= 1 && x <= 19 && y >= 1 && y <= 19 && arr[x][y] == n) {
                        count += 1;
                        x += dx[k];
                        y += dy[k];
                    }

                    if(count == 5) {
                        int fx = i - dx[k];
                        int fy = j - dy[k];
                        if(fx >= 1 && fx <= 19 && fy >= 1 && fy <= 19 && arr[fx][fy] == n) {
                            continue;
                        }

                        int rx = x;
                        int ry = y;

                        if (rx >= 1 && rx <= 19 && ry >= 1 && ry <= 19 && arr[rx][ry] == n) {
                            continue;
                        }

                        bw.write(n + "\n" + i + " " + j);
                        bw.flush();
                        bw.close();
                        br.close();

                        return;
                    }
                }
            }
        }

        bw.write("0");
        bw.flush();
        bw.close();
        br.close();

    }
}
