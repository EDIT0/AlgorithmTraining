package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class BFS_s2_1012 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int T, M, N, K, x, y, count;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] direction1 = {0, 0, 1, -1};
    public static int[] direction2 = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][M];
            visited = new boolean[N][M];
            count = 0;

            for(int j=0;j<K;j++) {
                st = new StringTokenizer(br.readLine(), " ");
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());

                arr[y][x] = 1;
            }

            for(int k=0;k<N;k++) {
                for(int h=0;h<M;h++) {
                    if(arr[k][h] == 1 && !visited[k][h]) {
                        count += 1;
                        bfs(new Model(k, h));
                    }
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(Model model) {
        Queue<Model> queue = new LinkedList<>();

        queue.offer(model);
        visited[model.y][model.x] = true;

        while (!queue.isEmpty()) {
            Model poll = queue.poll();

            int pollY = poll.y;
            int pollX = poll.x;

            for(int i=0;i<4;i++) {
                int d1 = direction1[i];
                int d2 = direction2[i];
                if(pollY + d1 >= 0 && pollY + d1 < N && pollX + d2 >= 0 && pollX + d2 < M) {
                    if(arr[pollY + d1][pollX + d2] == 1 && !visited[pollY + d1][pollX + d2]) {
                        visited[pollY + d1][pollX + d2] = true;
                        queue.offer(new Model(pollY + d1, pollX + d2));
                    }
                }
            }
        }
    }

    public static class Model {
        int y;
        int x;

        Model(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
