package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 백트래킹_s2_10819 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N;
    public static int[] arr;
    public static int[] result;
    public static boolean[] visited;
    public static int answer;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        result = new int[N];
        permutation(0);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void permutation(int depth) {
        if(N == depth) {
            int sum = 0;
            for(int i=1;i<result.length;i++) {
                sum += Math.abs(result[i-1] - result[i]);
            }
            answer = Math.max(answer, sum);
            return;
        }

        for(int i=0;i<arr.length;i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}
