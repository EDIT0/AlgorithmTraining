package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 백트래킹_g4_1987 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int R, C;
    public static String[][] board;
    public static boolean[] alphabetVisited = new boolean[26];
    public static int[] d1 = {0, 0, 1, -1};
    public static int[] d2 = {1, -1, 0, 0};
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new String[R][C];

        for(int i=0;i<R;i++) {
            String input = br.readLine();
            for(int j=0;j<input.length();j++) {
                String s = String.valueOf(input.charAt(j));
                board[i][j] = s;
            }
        }

        dfs(0, 0, 1);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int y, int x, int depth) {
        int alpha = board[y][x].charAt(0) - 'A';

        if(!alphabetVisited[alpha]) {
            alphabetVisited[alpha] = true;

            answer = Math.max(answer, depth);

            for(int i=0;i<4;i++) {
                int newY = y + d1[i];
                int newX = x + d2[i];
                if(newY >= 0 && newY < R && newX >= 0 && newX < C) {
                    dfs(newY, newX, depth + 1);
                }
            }
            alphabetVisited[alpha] = false;
        }

    }
}
