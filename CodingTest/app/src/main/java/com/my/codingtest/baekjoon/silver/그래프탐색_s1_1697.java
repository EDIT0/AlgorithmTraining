package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그래프탐색_s1_1697 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // +1, -1, 2*N
        // 5, 17 -> 4
        int answer = bfs2(N, K);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int N, int K) {
        boolean[] visited = new boolean[100001];
        Queue<Model> queue = new LinkedList<>();

        queue.offer(new Model(N, 0));

        while (!queue.isEmpty()) {
            Model pop = queue.poll();

            if(pop.location == K) {
                return pop.count;
            }

            if(!visited[pop.location]) {
                visited[pop.location] = true;
                if((pop.location + 1) >= 0 && (pop.location + 1) < 100001) {
                    queue.offer(new Model(pop.location + 1, pop.count + 1));
                }
                if((pop.location - 1) >= 0 && (pop.location - 1) < 100001) {
                    queue.offer(new Model(pop.location - 1, pop.count + 1));
                }
                if((pop.location * 2) >= 0 && (pop.location * 2) < 100001) {
                    queue.offer(new Model(pop.location * 2, pop.count + 1));
                }
            }
        }

        return -1;
    }

    public static class Model {
        int location;
        int count;

        Model(int l, int c) {
            location = l;
            count = c;
        }
    }

    public static int bfs2(int N, int K) {
        if (N == K) return 0;

        boolean[] visited = new boolean[100001];
        Queue<Model> queue = new LinkedList<>();

        queue.offer(new Model(N, 0));
        visited[N] = true;

        while (!queue.isEmpty()) {
            Model current = queue.poll();

            int[] nextPositions = {
                    current.location - 1,
                    current.location + 1,
                    current.location * 2
            };

            for (int next : nextPositions) {
                if (next < 0 || next > 100000 || visited[next]) {
                    continue;
                }

                if (next == K) {
                    return current.count + 1;
                }

                visited[next] = true;
                queue.offer(new Model(next, current.count + 1));
            }
        }

        return -1;
    }
}
