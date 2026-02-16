package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 너비우선탐색_g4_14502 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] d1 = {1, -1, 0, 0};
    public static int[] d2 = {0, 0, 1, -1};
    public static int answerCount = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0);

        bw.write(answerCount + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void makeWall(int count) {
        if(count == 3) {
            // 3개가 되면 바이러스 퍼뜨리기
            answerCount = Math.max(answerCount, makeVirus());
            return;
        }

        // 벽이 들어갈 수 있는 모든 경우를 체크
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(board[i][j] == 0) {
                    board[i][j] = 1;
                    makeWall(count + 1);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static int makeVirus() {
        int[][] tmpBoard = new int[N][M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                tmpBoard[i][j] = board[i][j];
            }
        }

        Queue<Model> queue = new LinkedList<>();
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(tmpBoard[i][j] == 2) {
                    queue.add(new Model(i, j));
                }
            }
        }

        visited = new boolean[N][M];

        while (!queue.isEmpty()) {
            Model pModel = queue.poll();

            if(!visited[pModel.y][pModel.x]) {
                visited[pModel.y][pModel.x] = true;

                for(int i=0;i<4;i++) {
                    int newY = pModel.y + d1[i];
                    int newX = pModel.x + d2[i];

                    if(newY >= 0 && newY < N && newX >= 0 && newX < M && tmpBoard[newY][newX] == 0) {
                        tmpBoard[newY][newX] = 2;
                        queue.add(new Model(newY, newX));
                    }
                }
            }
        }

        // 퍼진 바이러스 외의 0 구역 계산
        int resultCount = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(tmpBoard[i][j] == 0) {
                    resultCount += 1;
                }
            }
        }

        return resultCount;

    }

    public static class Model {
        int y, x;

        Model(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
