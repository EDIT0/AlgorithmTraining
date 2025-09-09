package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

// BFS, DFS
public class BFS_DFS_s2_1260 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M, V;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 정점의 갯수
        M = Integer.parseInt(st.nextToken()); // 간선의 갯수
        V = Integer.parseInt(st.nextToken()); // 시작 번호

        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        // 정렬
        for (int i=1;i<=N;i++) {
            Collections.sort(graph.get(i), (o1, o2) -> {
                if(o1 < o2) {
                    return -1;
                } else if(o1 > o2) {
                    return 1;
                } else {
                    return 0;
                }
            });
        }

        visited = new boolean[N+1];
        dfs(V);
        for(int i=0;i<answer.size();i++) {
            bw.write(answer.get(i) + " ");
        }

        bw.write("\n");

        answer = new ArrayList<>();
        visited = new boolean[N+1];

        bfs();
        for(int i=0;i<answer.size();i++) {
            bw.write(answer.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int node) {
        if(!visited[node]) {
            visited[node] = true;
            answer.add(node);

            for(int i=0;i<graph.get(node).size();i++) {
                dfs(graph.get(node).get(i));
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(V);
        visited[V] = true;
        answer.add(V);

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for(int i=0;i<graph.get(poll).size();i++) {
                if(!visited[graph.get(poll).get(i)]) {
                    answer.add(graph.get(poll).get(i));
                    visited[graph.get(poll).get(i)] = true;
                    queue.offer(graph.get(poll).get(i));
                }
            }
        }
    }

}