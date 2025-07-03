package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class BFS_s2_2644 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int a;
    public static int b;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        graph = new List[n+1];
        visited = new boolean[n+1];

        for(int i=1;i<=n;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[y].add(x);
            graph[x].add(y);
        }

        int answer = bfs(a, 0);
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int node, int distance) {
        Queue<Model> queue = new LinkedList<>();

        queue.offer(new Model(node, 0));
        visited[node] = true;

        while (!queue.isEmpty()) {
            Model poll = queue.poll();

            int n = poll.node;
            int d = poll.distance;

            if(n == b) {
                return d;
            }

            for(int i=0;i<graph[n].size();i++) {
                int next = graph[n].get(i);
                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Model(next, d+1));
                }
            }
        }

        return -1;
    }

    public static class Model {
        int node;
        int distance;

        Model(int n, int d) {
            node = n;
            distance = d;
        }
    }
}
