package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

// DFS, 완전 탐색
public class 구현_백트랙킹_s1_14225 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N;
    public static int[] arr;
    public static boolean[] visited;
    public static int answer = -1;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[100000 * 20 + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        for(int i=1;i<visited.length;i++) {
            if(visited[i]) {

            } else {
                answer = i;
                break;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int index, int sum) {
        if(index == N) {
//            System.out.println("sum: " + sum + "");
            if(sum != 0) {
                visited[sum] = true;
            }
            return;
        }

        dfs(index + 1, sum + arr[index]);
        dfs(index + 1, sum);
    }
}