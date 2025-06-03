package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s2_4358 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            HashMap<String, Double> hashMap = new HashMap<>();
            int totalCount = 0;

            while (true) {
                String treeName = br.readLine();
                if(treeName == null || treeName.equals("")) {
                    break;
                }

                hashMap.put(treeName, hashMap.getOrDefault(treeName, 0.0) + 1);
                totalCount += 1;
            }

            Object[] arr = hashMap.keySet().toArray();
            Arrays.sort(arr);

            for(int i=0;i<arr.length;i++) {
                Double percent = (hashMap.get(arr[i]) / totalCount) * 100;
                bw.write(arr[i] + " " + String.format("%.4f", percent) + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
