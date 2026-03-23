package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 * 1부터 N까지 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 고른 수열은 비내림차순이어야 한다.
 * 길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
 */
public class 백트래킹_s3_15652 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];

        combination(1, 0);

        bw.flush();
        bw.close();
        br.close();
    }

    // nCm
    public static void combination(int start, int depth) throws IOException {
        if(depth == M) {
            for(int i=0;i<result.length;i++) {
                bw.write(result[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i=start;i<=N;i++) {
            result[depth] = i;
            combination(i, depth + 1);
        }
    }
}
