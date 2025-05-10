package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 문자열_b2_9046 {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());

            for(int i=0;i<N;i++) {
                String str = br.readLine();
                HashMap<String, Integer> hashMap = new HashMap<>();
                int max = 0;
                String answer = "";

                for(int j=0;j<str.length();j++) {
                    if(str.charAt(j) == ' ') {
                        continue;
                    }

                    String key = String.valueOf(str.charAt(j));
                    hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
                }

                for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                    if(max < entry.getValue()) {
                        max = entry.getValue();
                        answer = entry.getKey();
                    } else if(max == entry.getValue()) {
                        answer = "?";
                    }
                }

                bw.write(answer + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
