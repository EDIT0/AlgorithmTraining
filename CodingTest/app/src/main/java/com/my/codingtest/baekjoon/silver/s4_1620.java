package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s4_1620 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Map<String, Integer> nameHashMap = new HashMap<String, Integer>();
            Map<Integer, String> numHashMap = new HashMap<Integer, String>();
            for(int i=0;i<N;i++) {
                String input = br.readLine();
                nameHashMap.put(input, i+1);
                numHashMap.put(i+1, input);
            }

            for(int i=0;i<M;i++) {
                String input = br.readLine();
                boolean isString = isString(input);

                if(isString) {
                    bw.write(nameHashMap.get(input) + "\n");
                } else {
                    bw.write(numHashMap.get(Integer.parseInt(input)) + "\n");
                }

                // 시간초과
//                for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
//                    if(isString(input) && entry.getKey().equals(input)) {
//                        bw.write(entry.getValue() + "\n");
//                    } else if(!isString(input) && entry.getValue() == Integer.parseInt(input)) {
//                        bw.write(entry.getKey() + "\n");
//                    }
//                }
            }

            // 시간초과
//            String[] nameArr = new String[N];
//            for(int i=0;i<N;i++) {
//                nameArr[i] = br.readLine();
//            }
//
//            boolean key = false;
//            for(int i=0;i<M;i++) {
//                String input = br.readLine();
//                if(isString(input)) {
//                    key = true;
//                } else {
//                    key = false;
//                }
//                if(key) {
//                    for(int j=0;j<N;j++) {
//                        if(nameArr[j].equals(input)) {
//                            bw.write(j + 1 + "\n");
//                        }
//                    }
//                } else {
//                    bw.write(nameArr[Integer.parseInt(input) - 1] + "\n");
//                }
//            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

    public static boolean isString(String str) {
        try {
            int a = Integer.parseInt(str);
            return false; // int면 false
        } catch (Exception e) {
            return true; // String이면 true
        }
    }
}
