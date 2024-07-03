package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s5_7785 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());
            Map<String, String> hashMap = new HashMap<>();

            StringTokenizer st;

            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                hashMap.put(st.nextToken(), st.nextToken());
            }

            ArrayList<String> strList = new ArrayList<>();
            for(Map.Entry<String, String> entry : hashMap.entrySet()) {
                if(entry.getValue().equals("enter")) {
                    strList.add(entry.getKey());
                }
            }

            Collections.sort(strList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.compareTo(o1); // 역순
                }
            });

            for(int i=0;i<strList.size();i++) {
                bw.write(strList.get(i) + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
