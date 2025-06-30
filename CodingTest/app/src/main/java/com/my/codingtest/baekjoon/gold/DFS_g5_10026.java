package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class DFS_g5_10026 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int N;
    public static String[][] arr;
    public static boolean[][] visited;
    public static int count = 0;
    public static int[] direction1 = { 0, 0, -1, 1 };
    public static int[] direction2 = { 1, -1, 0, 0 };
    public static int answer = 0;
    public static int[] answerArr = new int[2];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new String[N][N];

        for(int i=0;i<N;i++) {
            String input = br.readLine();
            for(int j=0;j<N;j++) {
                arr[i][j] = String.valueOf(input.charAt(j));
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // Type 0: 일반, 1: 적녹
        for(int type=0;type<2;type++) {
            visited = new boolean[N][N];
            answer = 0;
            count = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    count = 0;

                    String color = arr[i][j];
                    if(type == 1) {
                        color = redToGreen(arr[i][j]); // R을 G로 변경
                    }
                    dfs(type, color, i, j);
                    if(count != 0) {
                        answer += 1;
                    }
                }
            }
            answerArr[type] = answer;
            bw.write(answerArr[type] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int type, String color, int y, int x) {
        if(type == 0) {
            if(!visited[y][x] && color.equals(arr[y][x])) {
                visited[y][x] = true;
                count += 1;

                for(int i=0;i<4;i++) {
                    if((x + direction1[i]) < N && (x + direction1[i]) >= 0
                            && (y + direction2[i]) < N && (y + direction2[i]) >= 0) {
                        dfs(type, color, y + direction2[i], x + direction1[i]);
                    }
                }
            }
        } else if(type == 1) {
            String c = redToGreen(arr[y][x]); // R을 G로 변경
            if(!visited[y][x] && color.equals(c)) {
                visited[y][x] = true;
                count += 1;

                for(int i=0;i<4;i++) {
                    if((x + direction1[i]) < N && (x + direction1[i]) >= 0
                            && (y + direction2[i]) < N && (y + direction2[i]) >= 0) {
                        dfs(type, color, y + direction2[i], x + direction1[i]);
                    }
                }
            }
        }
    }

    public static String redToGreen(String color) {
        if(color.equals("R")) {
            return "G";
        }
        return color;
    }
}
