package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

/**
 * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오. N개의 자연수는 모두 다른 수이다.
 *
 * N개의 자연수 중에서 M개를 고른 수열
 * 고른 수열은 오름차순이어야 한다.
 *
 * 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class 백트래킹_s3_15655 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N, M;
    public static Integer[] arr;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new Integer[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1 > o2) {
                return 1;
            } else if(o1 < o2) {
                return -1;
            } else {
                return 0;
            }
        });

        combination(0, 0);

        bw.flush();
        bw.close();
        br.close();
    }


    public static void combination(int start, int depth) throws IOException {
        if(depth == M) {
            for(int i=0;i<result.length;i++) {
                bw.write(arr[result[i]] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i=start;i<arr.length;i++) {
            result[depth] = i;
            combination(i + 1, depth + 1);
        }
    }

}
