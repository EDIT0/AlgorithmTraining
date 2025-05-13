package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 구현_s5_7568 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());

            ArrayList<Model> list = new ArrayList<>();
            StringTokenizer st;
            int rank = 1;

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int w = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                list.add(new Model(w, t));
            }

            for(int i=0;i<list.size();i++) {
                Model model = list.get(i);
                rank = 1;
                for(int j=0;j<list.size();j++) {
                    if(i == j) {
                        continue;
                    }

                    if(model.weight < list.get(j).weight && model.tall < list.get(j).tall) {
                        rank += 1;
                    }
                }

                bw.write(rank + " ");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static class Model {
        int weight;
        int tall;

        public Model(int weight, int tall) {
            this.weight = weight;
            this.tall = tall;
        }
    }
}

