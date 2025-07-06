package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class BFS_s1_2178 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M;
    public static int minDistance = Integer.MAX_VALUE;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] direction1 = {0, 0, 1, -1};
    public static int[] direction2 = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for(int i=0;i<N;i++) {
            String input = br.readLine();

            for(int j=0;j<M;j++) {
                int n = Integer.parseInt(String.valueOf(input.charAt(j)));
                arr[i+1][j+1] = n;
            }
        }

        bfs(new Model(1, 1, 1));

        bw.write(minDistance + "");
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
            int pollDistance = poll.distance;

            if(pollY == N && pollX == M && minDistance > pollDistance) {
                minDistance = pollDistance;
            }

            for(int i=0;i<4;i++) {
                int d1 = direction1[i];
                int d2 = direction2[i];
                if(pollY + d1 > 0 && pollY + d1 <= N && pollX + d2 > 0 && pollX + d2 <= M) {
                    if(arr[pollY + d1][pollX + d2] == 1 && !visited[pollY + d1][pollX + d2]) {
                        visited[pollY + d1][pollX + d2] = true;
                        queue.offer(new Model(pollY + d1, pollX + d2, pollDistance + 1));
                    }
                }
            }
        }
    }

    public static class Model {
        int y, x, distance;

        Model(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.distance = d;
        }
    }
}
