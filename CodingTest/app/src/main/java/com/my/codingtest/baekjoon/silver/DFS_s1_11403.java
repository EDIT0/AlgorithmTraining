package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class DFS_s1_11403 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N;
    public static int[][] graph;
    public static int[][] arr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        graph = new int[N+1][N+1];

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=N;j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    graph[i][j] = 1;
                }
            }
        }

        for(int i=1;i<=N;i++) {
            visited = new boolean[N+1];
            dfs(i, i);
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }

        // Floyd-Warshall: 경로 존재 여부 파악
//        for (int k = 0; k < N; k++) {       // 경유지
//            for (int i = 0; i < N; i++) {   // 출발지
//                for (int j = 0; j < N; j++) { // 도착지
//                    if (arr[i][k] == 1 && arr[k][j] == 1) {
//                        arr[i][j] = 1;
//                    }
//                }
//            }
//        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start, int current) {
        for(int j=1;j<=N;j++) {
            if(graph[current][j] == 1 && !visited[j]) {
                visited[j] = true;
                arr[start][j] = 1;
//                System.out.println("(" + current + ", " + j + ") " + "1");
                dfs(start, j);
            }
        }
    }

}
