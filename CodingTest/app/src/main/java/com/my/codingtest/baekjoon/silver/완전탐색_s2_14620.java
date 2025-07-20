package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 완전탐색_s2_14620 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N;
    public static int[][] arr;
    public static boolean[][] visited;
    public static int[] direction1 = {0, 0, 0, 1, -1};
    public static int[] direction2 = {0, 1, -1, 0, 0};
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(new Model(0, 0));

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(Model model) {
        if(model.totalCount >= 3) {
            if(model.totalSum < answer && model.totalCount == 3) {
                // 카운트가 3번 심었고, totalSum이 answer보다 작으면 저장
                answer = model.totalSum;
            }
            return;
        }

        for (int y=1;y<N-1;y++) {
            for (int x=1;x<N-1;x++) {

                // 현재 y, x 좌표 및 상, 하, 좌, 우 검사해서 심을 수 있는지 확인
                boolean flag = true;
                for(int i=0;i<direction1.length;i++) {
                    if(y + direction1[i] >= 0 && y + direction1[i] < N && x + direction2[i] >= 0 && x + direction2[i] < N) {
                        if(!visited[y + direction1[i]][x + direction2[i]]) {

                        } else {
                            flag = false;
                        }
                    } else {
                        flag = false;
                    }
                }

                // 심을 수 있다면?
                if(flag) {
                    int s = 0;
                    // 합계 계산 및 방문 처리
                    for(int i=0;i<direction1.length;i++) {
                        visited[y + direction1[i]][x + direction2[i]] = true;
                        s += arr[y + direction1[i]][x + direction2[i]];
                    }

                    // 현재 계산한 값 토대로 다시 dfs 호출
                    dfs(new Model(model.totalCount + 1, model.totalSum + s));

                    // 돌아왔을 때는 방문시켰던 곳들 되돌리기
                    for(int i=0;i<direction1.length;i++) {
                        visited[y + direction1[i]][x + direction2[i]] = false;
                    }
                }
            }
        }
    }

    public static class Model {
        int totalCount, totalSum;

        Model(int totalCount, int totalSum) {
            this.totalCount = totalCount;
            this.totalSum = totalSum;
        }
    }
}