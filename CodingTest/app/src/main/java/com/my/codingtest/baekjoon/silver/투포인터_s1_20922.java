package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 투포인터_s1_20922 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int length = 0;

        while (end < N) {
            hashMap.put(arr[end], hashMap.getOrDefault(arr[end], 0) + 1);

            // arr[end] 숫자 갯수가 K보다 같거나 작아질때까지 배열 길이 줄이기
            while (hashMap.get(arr[end]) > K) {
                hashMap.put(arr[start], hashMap.get(arr[start]) - 1);
                start += 1;
            }

            if(end - start + 1 > length) {
                length = end - start + 1;
            }

            end += 1;
        }

        bw.write(length + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
