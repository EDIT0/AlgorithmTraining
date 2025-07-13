package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 완전탐색_s3_17484 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int[][] arr;
    public static int[] direction = {-1, 0, 1};
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        arr = new int[y][x];

        for(int i=0;i<y;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<x;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<x;i++) {
            answer = Math.min(answer, dfs(0, i, 0, 100));
        }

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int dfs(int y, int x, int sum, int directionNum) {
//        System.out.println("현재 경로: " + y + "/" + x);
        int newSum = arr[y][x] + sum;

        if(y == arr.length - 1) {
            return newSum;
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<direction.length;i++) {
            if(directionNum != direction[i]
                    && x + direction[i] >= 0 && x + direction[i] < arr[0].length
                    && y + 1 < arr.length
            ) {
//                int a = y+1;
//                int b = x + direction[i];
//                System.out.println("경로로 이동: " + a + "/" + b);
                int tmp = dfs(y+1, x + direction[i], newSum, direction[i]);
                min = Math.min(min, tmp);
            }
        }

        return min;
    }
}
