package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b2_2798 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;

            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long M = Long.parseLong(st.nextToken());
            st = new StringTokenizer(br.readLine());
            long[] arr = new long[(int) N];
            for(int i=0;i<N;i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            ArrayList<Long> arrList = new ArrayList<>();
            for(int i=0;i<N;i++) {
                for(int j=i+1;j<N;j++) {
                    for(int k=j+1;k<N;k++) {
                        long sum = arr[i] + arr[j] + arr[k];
                        if(sum <= M) {
                            arrList.add(arr[i] + arr[j] + arr[k]);
                        }
                    }
                }
            }

            Collections.sort(arrList);

            bw.write(arrList.get(arrList.size() - 1) + "");
            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
