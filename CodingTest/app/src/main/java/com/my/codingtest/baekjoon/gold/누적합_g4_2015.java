package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 누적합_g4_2015 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int[] arr;
    public static HashMap<Integer, Integer> hashMap = new HashMap<>();
    public static long answer = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");

        hashMap.put(0, 1); // 초기값

        for(int i=1;i<=N;i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n + arr[i-1];

            if(hashMap.containsKey(arr[i] - K)) {
                answer += hashMap.get(arr[i] - K);
            }

            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

}
