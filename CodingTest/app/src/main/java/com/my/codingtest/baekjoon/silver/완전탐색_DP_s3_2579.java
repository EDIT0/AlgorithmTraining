package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 완전탐색_DP_s3_2579 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] stepArr = new int[N+1];
        int[] answer = new int[N+1];

        for(int i=1;i<=N;i++) {
            stepArr[i] = Integer.parseInt(br.readLine());
        }

        /**
         * 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
         * 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
         * 마지막 도착 계단은 반드시 밟아야 한다.
         * */

        if(N >= 1) {
            answer[1] = stepArr[1];
        }

        if(N >= 2) {
            answer[2] = stepArr[1] + stepArr[2];
        }

        if(N >= 3) {
            answer[3] = Math.max(stepArr[1] + stepArr[3], stepArr[2] + stepArr[3]);
        }

        if(N >= 4) {
            for(int i=4;i<=N;i++) {
//            int a = answer[i-3] + stepArr[i-2] + stepArr[i]; // 중복
                int a = answer[i-3] + stepArr[i-1] + stepArr[i];
                int b = answer[i-2] + stepArr[i];
                answer[i] = Math.max(a, b);
//            System.out.println("i: " + i + " / " + answer[i]);
            }
        }

        bw.write(answer[N] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
