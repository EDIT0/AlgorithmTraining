package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

/**
 * BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.
 *
 * 오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.
 *
 * A는 B와 친구다.
 * B는 C와 친구다.
 * C는 D와 친구다.
 * D는 E와 친구다.
 * 위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
 * 둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.
 *
 * 문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.
 */
public class 백트래킹_g5_13023 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a, b == b, a 친구이므로 양방향
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N];
        dfs(0, 0);
        for(int i=0;i<N;i++) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
            if(answer == 1) {
                break;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start, int depth) {
        if(5 == depth) { // A, B, C, D, E 고정이므로 5명
            answer = 1;
            return;
        }

        for(int i=0;i<graph.get(start).size();i++) {
            int next = graph.get(start).get(i);
            if(!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
                visited[next] = false;
                if(answer == 1) {
                    break;
                }
            }
        }
    }
}
