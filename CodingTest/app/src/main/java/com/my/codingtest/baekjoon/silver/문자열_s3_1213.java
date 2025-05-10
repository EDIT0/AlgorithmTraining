package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 문자열_s3_1213 {

    /**
     * AABB -> ABBA
     * AAABB -> ABABA
     * ABACABA -> AABCBAA
     * ABCD -> I'm Sorry Hansoo
     * */

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String input = br.readLine();
            TreeMap<String, Integer> hashMap = new TreeMap<>();

            for(int i=0;i<input.length();i++) {
                String key = String.valueOf(input.charAt(i));
                hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            }

            // 문자열 길이가 짝수일 경우
            if(input.length() % 2 == 0) {
                for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                    if(entry.getValue() % 2 == 1) {
                        System.out.println("I'm Sorry Hansoo");
                        br.close();
                        return;
                    }
                }

                StringBuilder sb = new StringBuilder();
                for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                    for(int i=0;i<entry.getValue()/2;i++) {
                        sb.append(entry.getKey());
                    }
                }

                String half = sb.toString();
                String result = half + new StringBuilder(half).reverse();
                System.out.println(result);
            } else {
                // 문자열 길이가 홀수일 경우
                int n = 0;
                for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                    if(entry.getValue() % 2 == 1) {
                        n += 1;
                        if(n > 1) {
                            System.out.println("I'm Sorry Hansoo");
                            br.close();
                            return;
                        }
                    }
                }

                StringBuilder sb = new StringBuilder();
                String save = "";
                for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                    if(entry.getValue() % 2 == 1) {
                        save = entry.getKey();
                    }
                    for(int i=0;i<entry.getValue()/2;i++) {
                        sb.append(entry.getKey());
                    }
                }
                String half = sb.toString();
                String result = half + save + new StringBuilder(half).reverse();
                System.out.println(result);
            }

            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
