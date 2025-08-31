package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

// 조합
public class 구현_s1_14889 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N = 0;
    public static int[][] board;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N+1][N+1];

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1;j<=N;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] arr = new int[N];
        for(int i=1;i<=N;i++) {
            arr[i-1] = i;
        }
        combination(arr, new boolean[arr.length], 0, 0, N/2);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void combination(int[] arr, boolean[] visited, int start, int depth, int r){
        if(depth == r){
            int[] arr1 = new int[r];
            int[] arr2 = new int[r];
            int index1 = 0;
            int index2 = 0;
            for(int i=0; i<arr.length; i++){
                if(visited[i]) {
                    arr1[index1] = arr[i];
                    index1 += 1;
                } else {
                    arr2[index2] = arr[i];
                    index2 += 1;
                }
            }

            int s1 = teamPower(arr1);
            int s2 = teamPower(arr2);

            int s = Math.abs(s1 - s2);
            answer = Math.min(s, answer);
            return;
        }
        for(int i=start; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(arr, visited, i+1, depth+1, r);
                visited[i] = false;
            }
        }
    }

    public static int teamPower(int[] team) {
        int sum = 0;
        for (int i=0; i<team.length; i++) {
            for (int j=i+1; j<team.length; j++) {
                sum += board[team[i]][team[j]] + board[team[j]][team[i]];
            }
        }
        return sum;
    }
}
