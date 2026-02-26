package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 최단거리_g4_1753 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int V, E, K;
//    public static int[][] graph;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] dist; // 최소 거리 담기
    public static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

//        graph = new int[V+1][V+1];

        // 초기화 - 모든 간선 무한
//        for(int i=0;i<=V;i++) {
//            for(int j=0;j<=V;j++) {
//                graph[i][j] = INF;
//            }
//        }
        for(int i=0;i<=V;i++) {
            graph.add(new ArrayList<>());
        }

        // 본인 거리는 0
//        for(int i=0;i<=V;i++) {
//            graph[i][i] = 0;
//        }

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

//            graph[u][v] = w;
            graph.get(u).add(new Node(u, v, w));
        }

//        for(int i=0;i<graph.length;i++) {
//            for(int j=0;j<graph[i].length;j++) {
//                System.out.print("[" + i + "][" + j + "]" + "=" + graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        dijkstra(K);

        for(int i=1;i<=V;i++) {
            if(dist[i] == INF) {
                bw.write("INF\n");
            } else {
                bw.write(dist[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void dijkstra(int start) {
        dist = new int[V+1];
        for(int i=0;i<dist.length;i++) {
            dist[i] = INF;
        }
        dist[start] = 0;

        boolean[] visited = new boolean[V+1];

        for(int i=1;i<=V;i++) {
            int minDist = INF;
            int minNode = -1;

            // 방문하지 않은 정점 중 가장 가까운 정점 찾기
            for(int j=1;j<=V;j++) {
                if(!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    minNode = j;
                }
            }
//            System.out.println("MinNode: " + minNode + " MinDist: " + minDist);

            // 방문할 곳 없음
            if(minNode == -1) {
                break;
            }

            visited[minNode] = true;

            // 기존 거리 합산하여 최소 거리 저장
//            for(int j=1;j<=V;j++) {
//                System.out.println(dist[minNode] + " / " + graph[minNode][j] + " / " + dist[j]);
//                if(!visited[j] && graph[minNode][j] != INF) {
//                    int sum = dist[minNode] + graph[minNode][j];
//                    if(sum < dist[j]) {
//                        dist[j] = sum;
//                    }
//                }
//            }
            for(int j=0;j<graph.get(minNode).size();j++) {
                Node node = graph.get(minNode).get(j);
                int s = node.start;
                int e = node.end;
                int w = node.weight;
                if(!visited[e] && w != INF) {
                    int sum = dist[minNode] + w;
                    if(sum < dist[e]) {
                        dist[e] = sum;
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
