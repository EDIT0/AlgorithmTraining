package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s3_1449 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(arr.length == 0) {
            System.out.println("0");
            return;
        }
        if(arr.length == 1)  {
            System.out.println("1");
            return;
        }

        int answer = 1;
        int point = 0;

        Arrays.sort(arr);

        for(int i=1;i<arr.length;i++) {
            int d = arr[i] - arr[point];
            if(L-1 >= d) {

            } else {
                point = i;
                answer += 1;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
