package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 너비우선탐색_g5_7569 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M, H;
    public static int[][][] board;
    public static boolean[][][] visited;
    public static int[] dy = {1, -1, 0, 0, 0, 0};
    public static int[] dx = {0, 0, 1, -1, 0, 0};
    public static int[] dh = {0, 0, 0, 0, 1, -1};
    public static int answerCount = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][N][M];
        visited = new boolean[H][N][M];

        for(int k=0;k<H;k++) {
            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0;j<M;j++) {
                    board[k][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        findTomato();
        scanStatus();

        if(answerCount != -1) {
            answerCount -= 1;
        }

        bw.write(answerCount + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void findTomato() {
        Queue<Model> queue = new LinkedList<>();

        // 현재 익은 토마토 큐에 넣기
        for(int k=0;k<H;k++) {
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(board[k][i][j] == 1) {
                        queue.add(new Model(k, i, j));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Model pModel = queue.poll();

            for(int i=0;i<6;i++) {
                int newH = pModel.h + dh[i];
                int newY = pModel.y + dy[i];
                int newX = pModel.x + dx[i];

                if(newH >= 0 && newH < H && newY >= 0 && newY < N && newX >= 0 && newX < M && board[newH][newY][newX] == 0) {
                    board[newH][newY][newX] = board[pModel.h][pModel.y][pModel.x] + 1; // 일자 계산
                    queue.add(new Model(newH, newY, newX));
                }
            }
        }
    }

    public static void scanStatus() {
        for(int k=0;k<H;k++) {
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    int status = board[k][i][j];
                    answerCount = Math.max(answerCount, status);
                    if(status == 0) {
                        answerCount = -1;
                        return;
                    }
                }
            }
        }
    }

    public static class Model {
        int h, y, x;

        Model(int h, int y, int x) {
            this.h = h;
            this.y = y;
            this.x = x;
        }
    }
}
