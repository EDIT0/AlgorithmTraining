package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 깊이우선탐색_s2_4963 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int[][] board;
    public static int[] d1 = {1, -1, 0, 0, 1, -1, 1, -1};
    public static int[] d2 = {0, 0, 1, -1, 1, 1, -1, -1};
    public static int w, h;
    public static boolean[][] visited;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        while(true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) {
                break;
            }

            board = new int[h][w];
            visited = new boolean[h][w];

            for(int i=0;i<h;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            answer = 0;
            for(int i=0;i<h;i++) {
                for(int j=0;j<w;j++) {
                    if(!visited[i][j] && board[i][j] == 1) {
                        dfs(i, j);
                        answer += 1;
                    }
                }
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int y, int x) {
        int n = board[y][x];

        if(n == 0) {
            return;
        }

        visited[y][x] = true;

        for(int i=0;i<d1.length;i++) {
            int dd1 = d1[i];
            int dd2 = d2[i];

            int newY = y + dd1;
            int newX = x + dd2;
            if(newY >= 0 && newY < h && newX >= 0 && newX < w && board[newY][newX] == 1 && !visited[newY][newX]) {
                dfs(newY, newX);
            }
        }
    }
}
