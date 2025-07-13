package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 완전탐색_b1_2309 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int[] arr = new int[9];
        int sum = 0;
        int order1 = 0, order2 = 0;

        for(int i=0;i<9;i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if(i != j) {
                    int copySum = sum;
                    if(copySum - arr[i] - arr[j] == 100) {
                        order1 = i;
                        order2 = j;
                        break;
                    }
                }
            }
        }

        arr[order1] = 0;
        arr[order2] = 0;

        Arrays.sort(arr);

        for(int i=0;i<7;i++) {
            bw.write(arr[i+2] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
