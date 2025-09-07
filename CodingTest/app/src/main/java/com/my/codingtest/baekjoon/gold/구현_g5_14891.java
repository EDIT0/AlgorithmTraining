package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 구현_g5_14891 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static char[][] arr = new char[4][8];

    public static void main(String[] args) throws IOException {

        Model[] wheelInfo = new Model[4];

        for(int i=0;i<4;i++) {
            wheelInfo[i] = new Model();
            String input = br.readLine();
            for(int j=0;j<input.length();j++) {
                arr[i][j] = input.charAt(j);

                if(j == 0) {
                    wheelInfo[i].index12 = 0;
                } else if(j == 2) {
                    wheelInfo[i].indexR = 2;
                } else if(j == 6) {
                    wheelInfo[i].indexL = 6;
                }
            }
        }

        int K = Integer.parseInt(br.readLine());

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int wheel = Integer.parseInt(st.nextToken()); // 1, 2, 3, 4
            int direction = Integer.parseInt(st.nextToken()); // 1 or -1

            int[] dir = new int[4]; // 0=안 돌림, 1=시계, -1=반시계
            dir[wheel-1] = direction;

            // 왼쪽
            for (int j=wheel-1;j>0;j--) {
                if (arr[j][wheelInfo[j].indexL] != arr[j-1][wheelInfo[j-1].indexR]) {
                    dir[j-1] = -dir[j]; // 반대 방향
                } else {
                    break; // 극이 같으면 멈춤
                }
            }

            // 오른쪽
            for (int j=wheel-1;j<3;j++) {
                if (arr[j][wheelInfo[j].indexR] != arr[j+1][wheelInfo[j+1].indexL]) {
                    dir[j+1] = -dir[j];
                } else {
                    break;
                }
            }

            for(int j=0;j<dir.length;j++) {
                if(dir[j] == 1) {
                    // 시계 방향
                    wheelInfo[j].indexL -= 1;
                    wheelInfo[j].indexL = calIndex(wheelInfo[j].indexL);
                    wheelInfo[j].indexR -= 1;
                    wheelInfo[j].indexR = calIndex(wheelInfo[j].indexR);
                    wheelInfo[j].index12 -= 1;
                    wheelInfo[j].index12 = calIndex(wheelInfo[j].index12);
                } else if(dir[j] == -1) {
                    // 반시계 방향
                    wheelInfo[j].indexL += 1;
                    wheelInfo[j].indexL = calIndex(wheelInfo[j].indexL);
                    wheelInfo[j].indexR += 1;
                    wheelInfo[j].indexR = calIndex(wheelInfo[j].indexR);
                    wheelInfo[j].index12 += 1;
                    wheelInfo[j].index12 = calIndex(wheelInfo[j].index12);
                }
            }
        }

        int answer = 0;
        int standard = 1;
        for(int i=0;i<wheelInfo.length;i++) {
//            System.out.println(wheelInfo[i].index12 + " / " + wheelInfo[i].indexL + " / " + wheelInfo[i].indexR);

            // N극은 0, S극은 1
//            System.out.println(arr[i][wheelInfo[i].index12] + " / " + standard);
            if(arr[i][wheelInfo[i].index12] == '1') {
                answer += standard;
            }

            standard *= 2;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }

    public static int calIndex(int i) {
        if(i == 8) {
            return 0;
        } else if(i == -1) {
            return 7;
        }
        return i;
    }

    public static class Model {
        int index12, indexL, indexR;

        Model() {

        }

        Model(int index12, int indexL, int indexR) {
            this.index12 = index12;
            this.indexL = indexL;
            this.indexR = indexR;
        }
    }
}
