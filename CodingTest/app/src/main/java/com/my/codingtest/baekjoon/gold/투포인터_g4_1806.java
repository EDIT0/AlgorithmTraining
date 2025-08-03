package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 투포인터_g4_1806 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N+1];

        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = 1;
        int minLength = Integer.MAX_VALUE;
        int currentLength = 0;
        int currentSum = 0;

        while (end <= N+1) {
            System.out.println("N: " + N +
                    "\ncurrentSum: " + currentSum +
                    "\ncurrentLength: " + currentLength +
                    "\nstart: " + start +
                    "\nend: " + end);

            // S와 같거나 큰 수가 나올 경우, 현재 start 값 빼주고, start + 1
            if(currentSum >= S) {
                if(minLength > currentLength) {
                    minLength = currentLength;
                }
                currentSum -= arr[start];
                currentLength -= 1;
                start += 1;
            } else if(currentSum < S) {
                if(end <= N) {
                    currentSum += arr[end];
                    currentLength += 1;
                }
                end += 1;
            }
        }

        if(minLength == Integer.MAX_VALUE) {
            bw.write("0");
        } else {
            bw.write(minLength + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
