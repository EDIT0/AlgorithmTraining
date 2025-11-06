package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s4_1049 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] setArr = new int[M];
        int[] singleArr = new int[M];
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            setArr[i] = Integer.parseInt(st.nextToken());
            singleArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(setArr);
        Arrays.sort(singleArr);

        int answer = 0;
        if(N / 6 > 0) {
            int a = N / 6;
            answer += (Math.min(setArr[0] * a, (a*6) * singleArr[0]));

            int b = N % 6;
            answer += (Math.min(setArr[0], b * singleArr[0]));
        } else {
            int a = N % 6;
            answer += (Math.min(setArr[0], a * singleArr[0]));
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();

    }
}
