package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class BFS_s1_1743 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M, K;
    public static int maxCount, count;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] direction1 = {0, 0, 1, -1};
    public static int[] direction2 = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            arr[y][x] = 1;
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    count = 0;
                    bfs(new Model(i, j, 1));
                    if(count > maxCount) {
                        maxCount = count;
                    }
                }
            }
        }

        bw.write(maxCount + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(Model model) {
        Queue<Model> queue = new LinkedList<>();

        queue.offer(model);
        visited[model.y][model.x] = true;
        count += 1;

        while (!queue.isEmpty()) {
            Model poll = queue.poll();

            int pollY = poll.y;
            int pollX = poll.x;

            for(int i=0;i<4;i++) {
                int d1 = direction1[i];
                int d2 = direction2[i];
                if(pollY + d1 > 0 && pollY + d1 <= N && pollX + d2 > 0 && pollX + d2 <= M) {
                    if(!visited[pollY + d1][pollX + d2] && arr[pollY + d1][pollX + d2] == 1) {
                        visited[pollY + d1][pollX + d2] = true;
                        count += 1;
                        queue.offer(new Model(pollY + d1, pollX + d2, count));
                    }
                }
            }
        }
    }

    public static class Model {
        int y, x;

        Model(int y, int x, int c) {
            this.y = y;
            this.x = x;
        }
    }

}
