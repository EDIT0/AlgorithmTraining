package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class b1_10989 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[10000000];

            // 1. 가까스로 통과
//            for(int i=0;i<N;i++) {
//                arr[i] = Integer.parseInt(br.readLine());
//            }
//            Arrays.sort(arr);

            // 2. O(n^2) 시간초과
//            for(int i=0;i<N;i++) {
//                arr[i] = Integer.parseInt(br.readLine());
//            }
//            for(int i=0;i<N;i++) {
//                int minIndex = i;
//                for(int j=i+1;j<N;j++) {
//                    if(arr[minIndex] > arr[j]) {
//                        minIndex = j;
//                    }
//                }
//                int tmp = arr[i];
//                arr[i] = arr[minIndex];
//                arr[minIndex] = tmp;
//            }

//            for(int i=0;i<N;i++) {
//                bw.write(arr[i] + "\n");
//            }

            // 3. 카운팅 정렬
            for(int i=0;i<N;i++) {
                arr[Integer.parseInt(br.readLine())]++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<10000000;i++) {
                int num = arr[i];
                while(num > 0) {
                    sb.append(i + "\n");
                    num--;
                }
            }

            bw.write(sb + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
