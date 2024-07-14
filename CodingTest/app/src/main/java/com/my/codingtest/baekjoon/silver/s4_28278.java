package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s4_28278 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st;
            ArrayList<Integer> integerList = new ArrayList<>();

            // 맨 위가 가장 오른쪽

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                int x = 0;
                int y = 0; // 1번 명령용

                if(st.countTokens() == 2) { // 입력 값이 2개라면
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());
                } else {
                    x = Integer.parseInt(st.nextToken());
                }

                switch (x) {
                    case 1 : {
                        one(integerList, y);
                        break;
                    }
                    case 2 : {
                        two(integerList, bw);
                        break;
                    }
                    case 3 : {
                        three(integerList, bw);
                        break;
                    }
                    case 4 : {
                        four(integerList, bw);
                        break;
                    }
                    case 5 : {
                        five(integerList, bw);
                        break;
                    }
                    default: {

                    }
                }
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }

    public static ArrayList<Integer> one(ArrayList<Integer> integerList, int n) {
        integerList.add(n);
        return integerList;
    }

    public static void two(ArrayList<Integer> integerList, BufferedWriter bw) throws Exception {
        if(integerList.isEmpty()) {
            bw.write("-1\n");
            return;
        }

        bw.write(integerList.get(integerList.size() - 1) + "\n");
        integerList.remove(integerList.size() - 1);
    }

    public static void three(ArrayList<Integer> integerList, BufferedWriter bw) throws Exception {
        bw.write(integerList.size() + "\n");
    }

    public static void four(ArrayList<Integer> integerList, BufferedWriter bw) throws Exception {

        if(integerList.isEmpty()) {
            bw.write("1\n");
        } else {
            bw.write("0\n");
        }
    }

    public static void five(ArrayList<Integer> integerList, BufferedWriter bw) throws Exception {
        if(integerList.isEmpty()) {
            bw.write("-1\n");
        } else {
            bw.write(integerList.get(integerList.size() - 1) + "\n");
        }
    }
}
