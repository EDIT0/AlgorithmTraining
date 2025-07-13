package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 완전탐색_b2_22864 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken()); // 한시간동안 일한 피로드
        int B = Integer.parseInt(st.nextToken()); // 한시간동안 일처리양
        int C = Integer.parseInt(st.nextToken()); // 한시간 쉬면 C만큼 줄어듬
        int M = Integer.parseInt(st.nextToken()); // 피로도는 M 값을 못넘김

        int work = 0;
        int stamina = 0;

        for(int i=0;i<24;i++) {
            if(stamina + A <= M) {
                work += B;
                stamina += A;
            } else {
                stamina -= C;
                if(stamina < 0) {
                    stamina = 0;
                }
            }
        }

        bw.write(work + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
