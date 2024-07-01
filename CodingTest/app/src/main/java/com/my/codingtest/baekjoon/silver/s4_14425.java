package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s4_14425 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Map<String, Boolean> hashMapN = new HashMap<String, Boolean>();
            for(int i=0;i<N;i++) {
                hashMapN.put(br.readLine(), false);
            }

            int count = 0;
            for(int i=0;i<M;i++) {
                if(hashMapN.containsKey(br.readLine())) { // 키를 가지고 있다면
                    count++;
                }
            }

            for (Map.Entry<String, Boolean> entrySet : hashMapN.entrySet()) {
//                entrySet.getKey() 해시 키 얻기
//                entrySet.getValue() 해시 값 얻기
            }

            bw.write(count + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
