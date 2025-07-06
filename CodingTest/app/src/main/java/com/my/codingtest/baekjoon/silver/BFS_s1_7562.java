package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class BFS_s1_7562 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int T, l, startY, startX, endY, endX;
    public static int minCount;
    public static ArrayList<Integer> minCountArr = new ArrayList<>();
    public static int[] direction1 = {1, -1, 1, -1, 2, -2, 2, -2};
    public static int[] direction2 = {2, 2, -2, -2, 1, 1, -1, -1};
    public static int[][] arr;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            l = Integer.parseInt(br.readLine());

            arr = new int[l][l];
            visited = new boolean[l][l];
            minCount = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine(), " ");
            startY = Integer.parseInt(st.nextToken());
            startX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            endY = Integer.parseInt(st.nextToken());
            endX = Integer.parseInt(st.nextToken());

            bfs(new Model(startY, startX, 0));

            minCountArr.add(minCount);
        }

        for(int i=0;i<minCountArr.size();i++) {
            bw.write(minCountArr.get(i) + "\n");
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
            int pollCount = poll.count;

            if(pollY == endY && pollX == endX && minCount > pollCount) {
                minCount = pollCount;
            }

            for(int i=0;i<8;i++) {
                int d1 = direction1[i];
                int d2 = direction2[i];
                if(pollY + d1 >= 0 && pollY + d1 < l && pollX + d2 >= 0 && pollX + d2 < l) {
                    if(!visited[pollY + d1][pollX + d2]) {
                        visited[pollY + d1][pollX + d2] = true;
                        queue.offer(new Model(pollY + d1, pollX + d2, pollCount + 1));
                    }
                }
            }
        }
    }

    public static class Model {
        int y, x, count;

        Model(int y, int x, int c) {
            this.y = y;
            this.x = x;
            this.count = c;
        }
    }
}
