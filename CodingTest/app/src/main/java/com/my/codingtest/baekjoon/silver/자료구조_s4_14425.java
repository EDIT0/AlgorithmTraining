package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s4_14425 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            HashMap<String, Integer> hashMap = new HashMap<>();
            int count = 0;

            for(int i=0;i<N;i++) {
                String str = br.readLine();
                hashMap.put(str, 0);
            }

            for(int i=0;i<M;i++) {
                String str = br.readLine();
                if(hashMap.containsKey(str)) {
                    count += 1;
                }
            }

            bw.write(count + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
