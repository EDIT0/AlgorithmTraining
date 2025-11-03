package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s4_1026 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        Integer[] arr1 = new Integer[N];
        Integer[] arr2 = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2, (o1, o2) -> {
            if(o1 > o2) {
                return -1;
            } else if(o1 < o2) {
                return 1;
            } else {
                return 0;
            }
        });

        int answer = 0;
        for(int i=0;i<N;i++) {
            answer += (arr1[i] * arr2[i]);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
