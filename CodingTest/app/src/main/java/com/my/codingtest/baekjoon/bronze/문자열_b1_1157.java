package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 문자열_b1_1157 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String input = br.readLine();
            input = input.toUpperCase();

            HashMap<String, Integer> hashMap = new HashMap<>();
            int max = 0;
            String answer = "";

            for(int i=0;i<input.length();i++) {
                String key = String.valueOf(input.charAt(i));
                hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            }

            for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if(entry.getValue() > max) {
                    max = entry.getValue();
                    answer = entry.getKey();
                } else if(entry.getValue() == max) {
                    answer = "?";
                }
            }

            bw.write(answer);

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
