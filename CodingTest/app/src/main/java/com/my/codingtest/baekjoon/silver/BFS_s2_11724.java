package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

// BFS
public class BFS_s2_11724 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        boolean[] visited = new boolean[N+1];
        int answer = 0;

        for(int i=1;i<=N;i++) {

            Queue<Integer> queue = new LinkedList<>();

            if (!visited[i]) {
                answer += 1;
                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int poll = queue.poll();

                    for (int next : graph.get(poll)) {
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
