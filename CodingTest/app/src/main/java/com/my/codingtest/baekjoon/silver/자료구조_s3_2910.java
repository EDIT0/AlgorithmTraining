package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 자료구조_s3_2910 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;

            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            HashMap<Integer, Model> hashMap = new HashMap<>();
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0;i<N;i++) {
                int num = Integer.parseInt(st.nextToken());

                if(hashMap.containsKey(num)) {
                    Model model = hashMap.get(num);
                    model.count += 1;

                    hashMap.put(num, model);
                } else {
                    Model model = new Model(num, i, 1);

                    hashMap.put(num, model);
                }
            }

            ArrayList<Model> modelList = new ArrayList<>(hashMap.values());

            // Collections
            // 양수(1): 자리 바꾸기, 음수(-1): 자리 그대로 유지
            Collections.sort(modelList, (o1, o2) -> {
                if(o1.count > o2.count) {
                    return -1;
                } else if(o1.count == o2.count) {
                    if(o1.priority > o2.priority) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return 1;
                }
            });

            for(int i=0;i<modelList.size();i++) {
                for(int j=0;j<modelList.get(i).count;j++) {
                    bw.write(modelList.get(i).number + " ");
                }
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static class Model {
        int number;
        int priority;
        int count;

        Model(int n, int p, int c) {
            number = n;
            priority = p;
            count = c;
        }
    }
}
