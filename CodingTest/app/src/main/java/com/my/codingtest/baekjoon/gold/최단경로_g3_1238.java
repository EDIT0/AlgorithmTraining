package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 최단경로_g3_1238 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M, X;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] dist;
    public static int[] dist2;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()); // 파티를 벌이는 마을

        dist2 = new int[N+1];

        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(A, B, D));
        }

        for(int i=1;i<=N;i++) {
            dijkstra(i, X);
            dist2[i] = dist2[i] + dist[X];
//            for(int j=0;j<dist.length;j++) {
//                System.out.println("1. " + dist[j] + "");
//            }

            dijkstra(X, i);
            dist2[i] = dist2[i] + dist[i];
//            for(int j=0;j<dist.length;j++) {
//                System.out.println("2. " + dist[j] + "");
//            }
        }

        int max = 0;
        for(int i=1;i<dist2.length;i++) {
            if(max < dist2[i]) {
                max = dist2[i];
            }
        }

        bw.write(max + "");
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
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        pq.add(new int[] { destinationStart, dist[destinationStart] });

        boolean[] visited = new boolean[N+1];

        while (!pq.isEmpty()) {
            int[] p = pq.poll();

            int minDist = p[1];
            int minNode = p[0];

            if(visited[minNode]) {
                continue;
            }

            visited[minNode] = true;

            for(int j=0;j<graph.get(minNode).size();j++) {
                Node node = graph.get(minNode).get(j);
                int s = node.start;
                int e = node.end;
                int w = node.weight;
                if(!visited[node.end]) {
                    if(dist[e] > dist[minNode] + w) {
                        dist[e] = dist[minNode] + w;
                        pq.add(new int[] { e, dist[e]} );
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

//            System.out.println(minNode + " - " + minDist);

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
//                    System.out.println(dist[e] + " / " + e + " / " + w + " / " + dist[minNode]);
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
