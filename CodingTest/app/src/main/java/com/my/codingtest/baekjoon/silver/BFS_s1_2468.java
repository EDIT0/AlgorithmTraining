package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

// BFS
public class BFS_s1_2468 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N;
    public static int[][] board;
    public static boolean[][] visited;
    public static int[] directionX = { 0, 1, 0, -1};
    public static int[] directionY = { 1, 0, -1, 0};
    public static int[] answerArr = new int[101];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        for(int k=0;k<101;k++) {
            visited = new boolean[N][N];
            int answer = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(!visited[i][j]) {
                        answer += bfs(new Model(i, j), k);
                    }
                }
            }
            answerArr[k] = answer;
        }

        Arrays.sort(answerArr);

        bw.write(answerArr[answerArr.length-1] + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(Model model, int h) {
        int returnValue = 0;
        Queue<Model> queue = new LinkedList<>();

        if(board[model.x][model.y] <= h) {
            visited[model.x][model.y] = true;
            return returnValue;
        }

        queue.offer(model);
        visited[model.x][model.y] = true;
        returnValue = 1;

        while (!queue.isEmpty()) {
            Model push = queue.poll();

            int pushX = push.x;
            int pushY = push.y;

            for(int i=0;i<4;i++) {
                int dX = pushX + directionX[i];
                int dY = pushY + directionY[i];

                if(dX >= 0 && dX < N && dY >= 0 && dY < N && !visited[dX][dY] && board[dX][dY] > h) {
                    visited[dX][dY] = true;
                    queue.offer(new Model(dX, dY));
                }
            }
        }

        return returnValue;
    }

    public static class Model {
        int x, y;

        Model(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
