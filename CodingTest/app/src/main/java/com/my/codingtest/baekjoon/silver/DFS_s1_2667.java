package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class DFS_s1_2667 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] direction1 = { 0, 1, -1, 0};
    public static int[] direction2 = { 1, 0, 0, -1};
    public static int houseCount = 0;
    public static ArrayList<Integer> houseCountList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        for(int i=1;i<=N;i++) {
            String[] input = br.readLine().split("");
            for(int j=1;j<=N;j++) {
                arr[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        visited = new boolean[N+1][N+1];

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                houseCount = 0;
                dfs(i, j);
                if(houseCount != 0) {
                    houseCountList.add(houseCount);
                }
            }
        }

        bw.write(houseCountList.size() + "\n");
        Collections.sort(houseCountList);
        for(int i=0;i<houseCountList.size();i++) {
            bw.write(houseCountList.get(i) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y) {
        if(arr[x][y] == 1 && !visited[x][y]) {
            visited[x][y] = true;
            houseCount += 1;
//            System.out.println(x + "/" + y + "/" + houseCount);
            for(int i=0;i<direction1.length;i++) {
                if((x + direction1[i]) <= N && (x + direction1[i]) > 0
                        && (y + direction2[i]) <= N && (y + direction2[i]) > 0) {
                    dfs(x + direction1[i], y + direction2[i]);
                }
            }
        }
    }
}
