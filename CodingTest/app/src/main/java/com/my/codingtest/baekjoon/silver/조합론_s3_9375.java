package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 조합론_s3_9375 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        Map<String, Integer> hashMap = new HashMap<>();

        for(int i=0;i<T;i++) {
            int n = Integer.parseInt(br.readLine());
            hashMap.clear();
            for(int j=0;j<n;j++) {
                st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken();
                String type = st.nextToken();

                hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);
            }

            int count = 1;
            for(Map.Entry<String, Integer> entry: hashMap.entrySet()) {
//                System.out.println(entry.getKey() + " / " + entry.getValue());
                count *= (entry.getValue() + 1);
            }

            count -= 1;

            // 헤드기어 2개, 아이웨어 1개
            // 1, 1
            // 1, 1
            // 1, 0
            // 1, 0
            // 0, 1
            // 총 5개, 안입는 경우도 계산에 넣어야함.

            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
