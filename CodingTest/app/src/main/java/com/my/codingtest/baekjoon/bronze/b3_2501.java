package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b3_2501 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int idx = 0;
            int[] arr = new int[N];

            for(int i=0;i<N;i++) {
                int j = (N % (i+1));
                if(j == 0) { // 1부터 N까지 나눈 나머지가 0이라면
                    arr[idx] = i+1;
                    idx++;
                }
            }

            if(arr.length == 0) {
                bw.write("0");
            } else {
                bw.write("" + arr[K-1]);
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
