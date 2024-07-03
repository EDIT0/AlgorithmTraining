package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s5_10815 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;

            int N = Integer.parseInt(br.readLine()); // 상근이 숫자 카드 갯수
            int[] arrN = new int[N]; // 상근이 가지고 있는 카드 숫자들
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                arrN[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine()); // 찾아야 하는 숫자 카드 갯수
            int[] arrM = new int[M]; // 찾아야 하는 카드 숫자들
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++) {
                int value = Integer.parseInt(st.nextToken());
                arrM[i] = value;
            }

            Arrays.sort(arrN);

            for(int i=0;i<M;i++) {
                bw.write(binary(arrM[i], arrN) + " ");
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }

    public static int binary(int key, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if(arr[mid] == key) {
                return 1;
            } else if(arr[mid] < key) {
                start = mid + 1;
            } else if(arr[mid] > key) {
                end = mid - 1;
            }
        }

        return 0;
    }
}
