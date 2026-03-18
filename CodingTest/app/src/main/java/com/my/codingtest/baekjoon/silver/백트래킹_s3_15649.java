package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 백트래킹_s3_15649 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M;
    public static boolean[] visited;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        result = new int[M];

        permutation(0);

        bw.flush();
        bw.close();
        br.close();
    }

    // 순열 nPm
    public static void permutation(int depth) throws IOException {
        if (depth == M) {
            for (int i=0;i<result.length;i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i=1;i<=N;i++) {
            if (!visited[i]) {
                visited[i] = true; // 현재 방문 상태 변경
                result[depth] = i; // 결과 저장
                permutation(depth + 1); // 백트래킹
                visited[i] = false; // 방문 했던거 되돌리기
            }
        }
    }
}
