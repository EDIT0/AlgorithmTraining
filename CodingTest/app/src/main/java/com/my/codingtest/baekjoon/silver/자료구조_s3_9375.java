package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s3_9375 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st;

            Map<String, Integer> hashMap = new HashMap<>();
            ArrayList<Integer> intList = new ArrayList<>();
            int count;

            for(int i=0;i<N;i++) {
                int n = Integer.parseInt(br.readLine());

                hashMap.clear();
                intList.clear();
                count = 1;

                for(int j=0;j<n;j++) {
                    st = new StringTokenizer(br.readLine(), " ");
                    String name = st.nextToken();
                    String type = st.nextToken();
                    hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);
                }

                for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    int value = entry.getValue();

                    int a = value + 1;
                    intList.add(a);
                }

                for(int num : intList) {
                    count *= num;
                }

                bw.write(count-1 + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
