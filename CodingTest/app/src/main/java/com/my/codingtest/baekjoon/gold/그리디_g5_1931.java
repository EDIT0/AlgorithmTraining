package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 그리디_g5_1931 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] > o2[1]) {
                return 1;
            } else if(o1[1] == o2[1]) {
                if(o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return  -1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        });

        int end = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++) {
//            System.out.println(arr[i][0] + " / " + arr[i][1]);
            if(end <= arr[i][0]) {
                count += 1;
                end = arr[i][1];
            }
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
