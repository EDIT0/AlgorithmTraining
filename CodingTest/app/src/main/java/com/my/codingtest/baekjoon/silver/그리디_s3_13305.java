package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s3_13305 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] distance = new int[N-1];
        int[] gasPrice = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<distance.length;i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<gasPrice.length;i++) {
            gasPrice[i] = Integer.parseInt(st.nextToken());
        }

        int minPrice = Integer.MAX_VALUE;
        int answer = 0;
        for(int i=0;i<N-1;i++) {
            if(gasPrice[i] < minPrice) {
                minPrice = gasPrice[i];
            }
            answer += (minPrice * distance[i]);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
