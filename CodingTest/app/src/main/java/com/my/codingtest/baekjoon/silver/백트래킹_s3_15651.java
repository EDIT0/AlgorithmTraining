package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 */
public class 백트래킹_s3_15651 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M;
//    public static boolean[] visited;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//        visited = new boolean[N+1];
        result = new int[M];

        permutation(0);

        bw.flush();
        bw.close();
        br.close();
    }

    // nPm
    public static void permutation(int depth) throws IOException {
        if(depth == M) {
            for(int i=0;i<result.length;i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i=1;i<=N;i++) {
//            if(!visited[i]) {
//                visited[i] = true;
                result[depth] = i;
                permutation(depth + 1);
//                visited[i] = false;
//            }
        }
    }
}
