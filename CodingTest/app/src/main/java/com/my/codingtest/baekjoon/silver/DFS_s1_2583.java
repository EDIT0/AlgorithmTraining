package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class DFS_s1_2583 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int[][] arr;
    public static int[] direction1 = { 0, 0, 1, -1 };
    public static int[] direction2 = { 1, -1, 0, 0 };
    public static boolean[][] visited;
    public static int districtCount = 0;
    public static ArrayList<Integer> districtCountList = new ArrayList<>();
    public static int M, N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 왼쪽 상단이 0,0이 되도록 설정. (n, 높이-1-n) /  (n-1, 높이-n)
        // 0, 2 / 3, 1

        arr = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = M - 1 - Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = M - Integer.parseInt(st.nextToken());

//            System.out.println(x1 + "," + y1 + " / " + x2 + "," + y2);

            for(int y=y2;y<=y1;y++) {
                for(int x=x1;x<=x2;x++) {
//                    System.out.println(y + ", " + x);
                    arr[y][x] = 1;
                }
            }
        }

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
//                System.out.print(arr[i][j] + " ");
                districtCount = 0;
                dfs(i, j);
                if(districtCount != 0) {
                    districtCountList.add(districtCount);
                }
            }
//            System.out.println();
        }

        bw.write(districtCountList.size() + "\n");
        Collections.sort(districtCountList);
        for(int i=0;i<districtCountList.size();i++) {
            bw.write(districtCountList.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int y, int x) {
        if(arr[y][x] == 0 && !visited[y][x]) {
            visited[y][x] = true;
            districtCount += 1;

            for(int i=0;i<direction1.length;i++) {
                if((x + direction1[i]) < N && (x + direction1[i]) >= 0
                        && (y + direction2[i]) < M && (y + direction2[i]) >= 0) {
                    dfs(y + direction2[i], x + direction1[i]);
                }
            }
        }
    }
}
