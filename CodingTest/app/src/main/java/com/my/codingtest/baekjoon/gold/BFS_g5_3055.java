package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class BFS_g5_3055 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static String[][] arr;
    public static boolean[][] visited, waterVisited;
    public static int R, C, result;
    public static int[] direction1 = {0, 0, 1, -1};
    public static int[] direction2 = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*', 돌은 'X'로 표시되어 있다. 비버의 굴은 'D'로, 고슴도치의 위치는 'S'로

        arr = new String[R][C];
        visited = new boolean[R][C];
        waterVisited = new boolean[R][C];

        Queue<Model> waterQueue = new LinkedList<>();
        Queue<Model> hedgehogQueue = new LinkedList<>();

        for(int i=0;i<R;i++) {
            String input = br.readLine();
            for(int j=0;j<C;j++) {
                arr[i][j] = String.valueOf(input.charAt(j));
                if(arr[i][j].equals("*")) {
                    waterQueue.offer(new Model(i, j, 0));
                } else if(arr[i][j].equals("S")) {
                    hedgehogQueue.offer(new Model(i, j, 0));
                }
            }
        }

        bfs(waterQueue, hedgehogQueue);

        if(result == 0) {
            bw.write("KAKTUS");
        } else {
            bw.write(result + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(Queue<Model> waterQueue, Queue<Model> hedgehogQueue) {
        while (!hedgehogQueue.isEmpty()) {

            int waterSize = waterQueue.size();
            for(int i=0;i<waterSize;i++) {
                Model poll = waterQueue.poll();
                int pollY = poll.y;
                int pollX = poll.x;
                int pollDistance = poll.distance;

                for(int j=0;j<4;j++) {
                    int d1 = direction1[j];
                    int d2 = direction2[j];
                    if(pollY + d1 >= 0 && pollY + d1 < R && pollX + d2 >= 0 && pollX + d2 < C) {
                        if(!waterVisited[pollY + d1][pollX + d2] && arr[pollY + d1][pollX + d2].equals(".")) {
                            waterVisited[pollY + d1][pollX + d2] = true;
                            waterQueue.offer(new Model(pollY + d1, pollX + d2, pollDistance + 1));
                        }
                    }
                }
            }

            // 고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다. 즉, 다음 시간에 물이 찰 예정인 칸으로 고슴도치는 이동할 수 없다. 이동할 수 있으면 고슴도치가 물에 빠지기 때문이다.
            // 물 먼저 한 후 해야함

            int hedgehogSize = hedgehogQueue.size();
            for(int i=0;i<hedgehogSize;i++) {
                Model poll = hedgehogQueue.poll();
                int pollY = poll.y;
                int pollX = poll.x;
                int pollDistance = poll.distance;

                if(arr[pollY][pollX].equals("D")) {
                    result = pollDistance;
                    return;
                }

                for(int j=0;j<4;j++) {
                    int d1 = direction1[j];
                    int d2 = direction2[j];
                    if(pollY + d1 >= 0 && pollY + d1 < R && pollX + d2 >= 0 && pollX + d2 < C) {
                        if(!waterVisited[pollY + d1][pollX + d2] && !visited[pollY + d1][pollX + d2] && (arr[pollY + d1][pollX + d2].equals(".") || arr[pollY + d1][pollX + d2].equals("D"))) {
                            visited[pollY + d1][pollX + d2] = true;
                            hedgehogQueue.offer(new Model(pollY + d1, pollX + d2, pollDistance + 1));
                        }
                    }
                }
            }
        }
    }

    public static class Model {
        int y, x, distance;

        Model(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

}
