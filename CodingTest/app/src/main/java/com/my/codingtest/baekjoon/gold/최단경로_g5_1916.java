package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 최단경로_g5_1916 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(s, e, w));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int destinationStart = Integer.parseInt(st.nextToken());
        int destinationEnd = Integer.parseInt(st.nextToken());

        dijkstra(destinationStart, destinationEnd);

        bw.write(dist[destinationEnd] + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int destinationStart, int destinationEnd) {
        dist = new int[N+1];

        for(int i=0;i<dist.length;i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[destinationStart] = 0;

        priorityQueue(destinationStart);
//        noPriorityQueue();
    }

    public static void priorityQueue(int destinationStart) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        pq.add(new int[] { destinationStart, dist[destinationStart] });

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

    public static void noPriorityQueue() {
        boolean[] visited = new boolean[N+1];

        for(int i=1;i<=N;i++) {
            int minDist = Integer.MAX_VALUE;
            int minNode = -1;

            for(int j=1;j<=N;j++) {
                if(!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    minNode = j;
                }
            }

            System.out.println(minNode + " - " + minDist);

            if(minNode == -1) {
                break;
            }

            visited[minNode] = true;

            for(int j=0;j<graph.get(minNode).size();j++) {
                Node node = graph.get(minNode).get(j);
                int s = node.start;
                int e = node.end;
                int w = node.weight;
                if(!visited[node.end]) {
                    System.out.println(dist[e] + " / " + e + " / " + w + " / " + dist[minNode]);
                    if(dist[e] > dist[minNode] + w) {
                        dist[e] = dist[minNode] + w;
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
