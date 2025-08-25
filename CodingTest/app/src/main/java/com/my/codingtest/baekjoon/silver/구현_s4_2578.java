package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 구현_s4_2578 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int[][] originalArr = new int[5][5];
        int[][] positionArr = new int[5*5+1][2];
        int[] orderArr = new int[5*5];

        for(int i=0;i<5;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<5;j++) {
                originalArr[i][j] = Integer.parseInt(st.nextToken());
                positionArr[originalArr[i][j]][0] = i;
                positionArr[originalArr[i][j]][1] = j;
            }
        }

        int index = 0;
        for(int i=0;i<5;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<5;j++) {
                orderArr[index] = Integer.parseInt(st.nextToken());
                index += 1;
            }
        }


        int[] bingGoRow = new int[5];
        int[] bingGoCol = new int[5];

        int cross1 = 0;
        int cross2 = 0;

        int bingGo = 0;
        int answer = 0;

        for(int i=0;i<orderArr.length;i++) {
            int n = orderArr[i];

            int x = positionArr[n][0];
            int y = positionArr[n][1];

            if(x == y) {
                cross1 += 1;
            }
            if(x + y == 4) {
                cross2 += 1;
            }

            if(cross1 == 5) {
                bingGo += 1;
            }
            if(cross2 == 5) {
                bingGo += 1;
            }

            bingGoRow[x] = bingGoRow[x] + 1;
            bingGoCol[y] = bingGoCol[y] + 1;

            for(int k=0;k<5;k++) {
                if(bingGoRow[k] == 5) {
                    bingGo += 1;
                }
                if(bingGoCol[k] == 5) {
                    bingGo += 1;
                }
            }

            if(bingGo >= 3) {
                answer = i+1;
                break;
            }
            bingGo = 0;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
