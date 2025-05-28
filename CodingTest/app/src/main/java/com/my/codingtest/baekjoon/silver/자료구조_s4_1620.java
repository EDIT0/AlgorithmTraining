package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s4_1620 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Map<Integer, String> hashMap1 = new HashMap<>();
            Map<String, Integer> hashMap2 = new HashMap<>();

            for(int i=1;i<=N;i++) {
                String name = br.readLine();
                hashMap1.put(i, name);
                hashMap2.put(name, i);
            }

            for(int i=0;i<M;i++) {
                String input = br.readLine();

                if(isNumber(input)) {
                    String name = hashMap1.get(Integer.parseInt(input));
                    bw.write(name + "\n");
                } else {
                    int number = hashMap2.get(input);
                    bw.write(number + "\n");
                }
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
