package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

// 완전탐색
public class 구현_b1_10448 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());


        int n = 1;
        int index = 1;
        while (n < 1000) {
            n = (index*(index+1)) / 2;
            index += 1;

            if(n < 1000) {
                list.add(n);
            }
        }

//        for(int i=0;i<list.size();i++) {
//            System.out.print(list.get(i) + " ");
//        }

        for(int i=0;i<T;i++) {
            int input = Integer.parseInt(br.readLine());

            boolean is = check(input);

            if(is) {
                bw.write("1\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean check(int input) {
        boolean is = false;
        for(int i=0;i<list.size();i++) {
            for(int j=0;j<list.size();j++) {
                for(int k=0;k<list.size();k++) {
                    if(input == list.get(i) + list.get(j) + list.get(k)) {
                        is = true;
                        return is;
                    }
                }
            }
        }
        return is;
    }
}
