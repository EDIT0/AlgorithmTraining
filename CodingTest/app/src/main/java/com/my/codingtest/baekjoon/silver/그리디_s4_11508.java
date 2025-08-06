package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s4_11508 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1 - o2 > 0) {
                return -1;
            } else if(o1 == o2){
                return 0;
            } else {
                return 1;
            }
        });

        int count = 0;
        long sum = 0;

        for(int i=0;i<arr.length;i++) {
            count += 1;
            if(count % 3 != 0) {
                sum += arr[i];
            }
        }

        bw.write(sum + " ");

        bw.flush();
        bw.close();
        br.close();
    }

}
