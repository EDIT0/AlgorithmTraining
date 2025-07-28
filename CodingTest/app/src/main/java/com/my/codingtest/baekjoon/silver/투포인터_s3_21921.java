package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 투포인터_s3_21921 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int currentSum = 0;
        int count = 1;

        for(int i=0;i<X;i++) {
            currentSum += arr[i];
        }
        max = currentSum;

        for(int i=X;i<N;i++) {
            currentSum = currentSum - arr[i-X] + arr[i];

            if(currentSum > max) {
                max = currentSum;
                count = 1;
            } else if(currentSum == max) {
                count += 1;
            }
        }

        if(max == 0) {
            bw.write("SAD");
        } else {
            bw.write(max + "\n" + count);
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
