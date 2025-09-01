package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

// 완전탐색
public class 구현_s4_1018 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int canN = N - 7;
        int canM = M - 7;

        char[][] board = new char[N][M];

        for(int i=0;i<N;i++) {
            String input = br.readLine();
            for(int j=0;j<M;j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int startX = 0;
        int startY = 0;
        int answer = Integer.MAX_VALUE;

        for(int i=0;i<canN;i++) {
            for(int j=0;j<canM;j++) {
                int currentW = 0;
                int currentB = 0;

                for(int x=startX;x<startX+8;x++) {
                    for(int y=startY;y<startY+8;y++) {
                        char c = board[x][y];

                        if((x+y) % 2 == 0) {
                            if(c == 'W') {
                                currentW += 1;
                            }
                            if(c == 'B') {
                                currentB += 1;
                            }
                        } else {
                            if(c == 'W') {
                                currentB += 1;
                            }
                            if(c == 'B') {
                                currentW += 1;
                            }
                        }
                    }
                }

                int min = Math.min(currentW, currentB);
                answer = Math.min(answer, min);

                startY += 1;
            }
            startX += 1;
            startY = 0;
        }


        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
