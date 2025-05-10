package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 문자열_s4_1764 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            HashMap<String, Integer> hashMap = new HashMap();

            for(int i=0;i<N;i++) {
                String name = br.readLine();
                hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
            }

            for(int i=0;i<M;i++) {
                String name = br.readLine();
                hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
            }

            ArrayList<String> nameList = new ArrayList<>();
            for(Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                if(entry.getValue() > 1) {
                    nameList.add(entry.getKey());
                }
            }

            Collections.sort(nameList);

            bw.write(nameList.size() + "\n");
            for(int i=0;i<nameList.size();i++) {
                bw.write(nameList.get(i) + "\n");
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }

}
