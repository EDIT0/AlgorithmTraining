package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그래프_이론_s3_2606 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        boolean[] visited = new boolean[N+1];

//        int answer = bfs(graph, 1, visited);

        int answer = dfs(graph, 1, visited, 0) - 1;

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(ArrayList<ArrayList<Integer>> graph, int startNode, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int answer = 0;

        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for(int i=0;i<graph.get(poll).size();i++) {
                int newNode = graph.get(poll).get(i);

                if(!visited[newNode]) {
                    queue.add(newNode);
                    visited[newNode] = true;
                    answer += 1;
                }
            }
        }
        return answer;
    }

    public static int dfs(ArrayList<ArrayList<Integer>> graph, int startNode, boolean[] visited, int answer) {
        if(!visited[startNode]) {
            visited[startNode] = true;
            answer += 1;

            for(int i=0;i<graph.get(startNode).size();i++) {
                int newNode = graph.get(startNode).get(i);
                answer = dfs(graph, newNode, visited, answer);
            }
        }

        return answer;
    }
}
