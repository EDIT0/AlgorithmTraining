package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s5_1439 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String S = br.readLine();

        int answer = Integer.MAX_VALUE;

        if(S.contains("0") && S.contains("1")) {
            String currentS = "";
            HashMap<String, Integer> hashMap = new HashMap<>();
            for(int i=0;i<S.length();i++) {
                char c = S.charAt(i);
                String s = String.valueOf(c);
                if(!currentS.equals(s)) {
                    hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
                    currentS = s;
                }
            }

            for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                int v = entry.getValue();
                if(answer > v) {
                    answer = v;
                }
            }
        } else {
            answer = 0;
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
