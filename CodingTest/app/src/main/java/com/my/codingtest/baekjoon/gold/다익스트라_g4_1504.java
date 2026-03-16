package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 다익스트라_g4_1504 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, E;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(a, b, c));
            graph.get(b).add(new Node(b, a, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 1번 출발
        // N번 도착

        dijkstra(1);
        int startToU = dist[u];
        int startToV = dist[v];
//        for(int i=0;i<dist.length;i++) {
//            System.out.println("1. " + dist[i] + " ");
//        }
        dijkstra(u);
        int uToV = dist[v];
        int uToN = dist[N];
//        for(int i=0;i<dist.length;i++) {
//            System.out.println("2. " + dist[i] + " ");
//        }
        dijkstra(v);
        int vToU = dist[u];
        int vToN = dist[N];
//        for(int i=0;i<dist.length;i++) {
//            System.out.println("3. " + dist[i] + " ");
//        }

        int flag = 0;
        if(startToU == Integer.MAX_VALUE || uToV == Integer.MAX_VALUE || vToN == Integer.MAX_VALUE) {
            flag = flag + 1;
        }
        if(startToV == Integer.MAX_VALUE || vToU == Integer.MAX_VALUE || uToN == Integer.MAX_VALUE) {
            flag = flag + 2;
        }

        long path1 = (long)startToU + uToV + vToN;
        long path2 = (long)startToV + vToU + uToN;

//        System.out.println(path1 + " / " + path2);
        long answer = 0;
        if(flag == 0) {
            answer = Math.min(path1, path2);
        } else if(flag == 1) {
            answer = path2;
        } else if(flag == 2) {
            answer = path1;
        } else {
            answer = -1;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int startNode) {
        dist = new int[N+1];
        for(int i=0;i<dist.length;i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[startNode] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] { startNode, dist[startNode] });

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
                int s = newNode.start;
                int e = newNode.end;
                int w = newNode.weight;

                if(!visited[e]) {
                    if(dist[e] > dist[node] + w) {
                        dist[e] = dist[node] + w;
                        pq.add(new int[] { e, dist[e] });
                    }
                }
            }
        }
    }
    public static class Node {
        int start;
        int end;
        int weight;

        public Node (int s, int e, int w) {
            start = s;
            end = e;
            weight = w;
        }
    }
}
