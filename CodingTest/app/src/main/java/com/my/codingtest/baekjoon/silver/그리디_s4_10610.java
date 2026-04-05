package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s4_10610 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String N = br.readLine();

        Integer[] arr = new Integer[N.length()];
        for(int i = 0; i< N.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(N.charAt(i)));
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1 < o2) {
                return 1;
            } else if(o1 > o2){
                return -1;
            } else {
                return 0;
            }
        });

        boolean passKey = false;
        int answer = -1;

        for(int i=0;i<arr.length;i++) {
//            System.out.println(arr[i] + "");
            if(arr[i] == 0) {
                passKey = true;
            }
        }

        if(passKey) {
            int sum = 0;
            for(int i=0;i<arr.length;i++) {
                sum += arr[i];
            }
            if(sum % 3 == 0) {
                passKey = true;
            } else {
                passKey = false;
                bw.write(answer + "");
            }
        } else {
            bw.write(answer + "");
            passKey = false;
        }

        if(passKey) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<arr.length;i++) {
                sb.append(arr[i]);
            }
            bw.write(sb + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}