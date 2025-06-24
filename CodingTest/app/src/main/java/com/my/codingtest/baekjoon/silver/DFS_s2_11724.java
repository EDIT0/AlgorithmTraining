package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class DFS_s2_11724 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int[][] arr;
    public static boolean[] visited;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        for(int i=1;i<=N;i++) {
            if(!visited[i]) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                visited[i] = true;

                while (!stack.isEmpty()) {
                    int pop = stack.pop();

                    for(int j=1;j<=N;j++) {
                        if(!visited[j] && arr[pop][j] == 1) {
                            stack.push(j);
                            visited[j] = true;
                        }
                    }
                }
                answer += 1;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
