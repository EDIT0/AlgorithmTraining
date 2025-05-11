package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 문자열_s3_20291 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());

            TreeMap<String, Integer> treeMap = new TreeMap<>();

            for(int i=0;i<N;i++) {
                boolean isSave = false;
                StringBuilder fileType = new StringBuilder();
                String input = br.readLine();

                for(int j=0;j<input.length();j++) {
                    if(input.charAt(j) == '.') {
                        isSave = true;
                    } else if(isSave) {
                        fileType.append(input.charAt(j));
                    }
                }

                treeMap.put(fileType.toString(), treeMap.getOrDefault(fileType.toString(), 0) + 1);
            }

            List<String> list = new ArrayList<>(treeMap.keySet());
//            Collections.sort(list);

            for(int i=0;i<list.size();i++) {
                bw.write(list.get(i) + " " + treeMap.get(list.get(i)) + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
