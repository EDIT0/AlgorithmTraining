package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class BFS_g5_7576 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int M, N;
    public static int[][] arr;
    public static boolean[][] visited;
    public static ArrayList<Model> startSpotList = new ArrayList<>();
    public static int[] direction1 = {0, 0, 1, -1};
    public static int[] direction2 = {1, -1, 0, 0};
    public static int maxDay = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++) {
                int input = Integer.parseInt(st.nextToken());
                if(input == 1) {
                    startSpotList.add(new Model(i, j, 0));
                }
                if(input == -1) {
                    // 토마토가 없는 칸
                    visited[i][j] = true;
                }
                arr[i][j] = input;
            }
        }

        bfs(startSpotList);

        // 익지 않은 토마토가 있는지 확인
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(!visited[i][j]) {
                    maxDay = -1;
                }
            }
        }

        bw.write(maxDay + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(ArrayList<Model> list) {
        Queue<Model> queue = new LinkedList<>();

        for(int i=0;i<list.size();i++) {
            queue.offer(list.get(i));
            visited[list.get(i).y][list.get(i).x] = true;
        }

        while (!queue.isEmpty()) {
            Model poll = queue.poll();

            if(maxDay < poll.day) {
                maxDay = poll.day;
            }

            int pollY = poll.y;
            int pollX = poll.x;
            int pollDay = poll.day;

            for(int i=0;i<4;i++) {
                int d1 = direction1[i];
                int d2 = direction2[i];
                if(pollY + d1 >= 0 && pollY + d1 < N && pollX + d2 >= 0 && pollX + d2 < M) {
                    if(!visited[pollY + d1][pollX + d2] && arr[pollY + d1][pollX + d2] == 0) {
                        visited[pollY + d1][pollX + d2] = true;
                        queue.offer(new Model(pollY + d1, pollX + d2, pollDay + 1));
                    }
                }
            }
        }
    }


    public static class Model {
        int y, x, day;

        Model(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}
