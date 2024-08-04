package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s2_11053 {
    public static void main(String[] args) {

        // 100,000,000

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> result = new ArrayList<>();
            for(int i=0;i<A.length;i++) {
                result.add(i, 0);
                for(int j=0;j<i;j++) {
                    if(A[j] < A[i]) {
                        result.set(i, Math.max(result.get(i), result.get(j) + 1));
                    }
                }
            }

            Map<Integer, Integer> hashMap = new HashMap<>();
            for(int i=0;i<result.size();i++) {
//                bw.write(result.get(i) + " ");
                hashMap.put(result.get(i), A[i]);
            }

//            bw.write("\n");
//            for(int i=0;i<hashMap.size();i++) {
//                bw.write(hashMap.get(i) + " ");
//            }

            bw.write(hashMap.size() + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }

    }
}
