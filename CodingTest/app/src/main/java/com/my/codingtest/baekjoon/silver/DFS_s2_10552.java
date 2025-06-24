package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class DFS_s2_10552 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int[] arr; // 싫어하는 채널
    public static HashMap<Integer, Integer> hashMap = new HashMap<>(); // 싫어하는 채널에서 넘길 좋아하는 채널 담기
    public static boolean[] visited;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 채널 수
        int P = Integer.parseInt(st.nextToken()); // 시작 채널

        arr = new int[M+1];
        visited = new boolean[M+1];

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[b] = 1;
            if(!hashMap.containsKey(b)) {
                hashMap.put(b, a);
            }
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(P);
        visited[P] = true;

        while (!stack.isEmpty()) {
            int pop = stack.pop();

            if(hashMap.containsKey(pop)) {
                int next = hashMap.get(pop);

                if(!visited[next]) {
                    stack.push(next);
                    visited[next] = true;
                    answer += 1;
                } else {
                    answer = -1;
                    break;
                }
            } else {
                break;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
