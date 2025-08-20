package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 그리디_g5_2212 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        Integer[] arr = new Integer[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1 > o2) {
                return 1;
            } else if(o1 < o2) {
                return -1;
            } else {
                return 0;
            }
        });

        Integer[] arr2 =  new Integer[N-1];
        for(int i=1;i<arr.length;i++){
//            System.out.print(arr[i] + " ");
            arr2[i-1] = arr[i] - arr[i-1];
        }

        Arrays.sort(arr2, (o1, o2) -> {
            if(o1 > o2) {
                return -1;
            } else if(o1 < o2) {
                return 1;
            } else {
                return 0;
            }
        });

        int count = 1;
        int answer = 0;
        for(int i=0;i<arr2.length;i++) {
            if(count < K) {

            } else {
                answer += arr2[i];
            }
            count += 1;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
