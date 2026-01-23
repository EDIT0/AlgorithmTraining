package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 정렬_s4_1920 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] box = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(box);

        for(int i=0;i<M;i++) {
            bw.write(binarySearch(box, arr[i]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int binarySearch(int[] box, int n) {
        int start = 0;
        int end = box.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if(box[mid] == n) {
                return 1;
            }

            if(box[mid] > n) {
                end = mid - 1;
            } else if(box[mid] < n) {
                start = mid + 1;
            }
        }

        return 0;
    }
}
