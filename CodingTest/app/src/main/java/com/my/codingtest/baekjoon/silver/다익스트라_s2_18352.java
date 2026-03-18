package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 다익스트라_s2_18352 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M, K, X;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[N+1];
        for(int i=0;i<dist.length;i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(A, B, 1));
        }

        dijkstra(X);

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<dist.length;i++) {
            if(dist[i] == K) {
                sb.append(i + "\n");
            }
        }

        if(sb.length() == 0) {
            bw.write("-1");
        } else {
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        dist[start] = 0;
        pq.add(new int[] { start, dist[start] });

        boolean[] visited = new boolean[N+1];

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int node = p[0];
            int weight = p[1];

            if(visited[node]) {
                continue;
            }

            visited[node] = true;

            for(int i=0;i<graph.get(node).size();i++) {
                Node newNode = graph.get(node).get(i);

                if(!visited[newNode.end]) {
                    if(dist[newNode.end] > dist[node] + newNode.weight) {
                        dist[newNode.end] = dist[node] + newNode.weight;
                        pq.add(new int[] { newNode.end, dist[newNode.end] });
                    }
                }
            }
        }
    }

    public static class Node {
        int start, end, weight;

        Node(int s, int e, int w) {
            start = s;
            end = e;
            weight = w;
        }
    }
}
