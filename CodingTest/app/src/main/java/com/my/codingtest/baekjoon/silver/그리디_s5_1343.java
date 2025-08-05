package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s5_1343 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String board = br.readLine();

//        board = board.replaceAll("XXXX", "AAAA");
//        board = board.replaceAll("XX", "BB");
//
//        if(board.contains("X")) {
//            bw.write("-1");
//        } else {
//            bw.write(board + "");
//        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        boolean isStop = false;
        for(int i=0;i<board.length();i++) {
            if(board.charAt(i) == '.') {
                int a = count / 4;
                int r = count % 4;
                int b = r / 2;
                r = r % 2;
                for(int j=0;j<a;j++) {
                    sb.append("AAAA");
                }
                for(int j=0;j<b;j++) {
                    sb.append("BB");
                }
                sb.append(".");
                count = 0;

                if(r != 0) {
                    isStop = true;
                    break;
                }
            } else {
                count += 1;
            }
        }

        int a = count / 4;
        int r = count % 4;
        int b = r / 2;
        r = r % 2;
        for(int j=0;j<a;j++) {
            sb.append("AAAA");
        }
        for(int j=0;j<b;j++) {
            sb.append("BB");
        }

        if(r != 0) {
            isStop = true;
        }

        if(isStop) {
            bw.write("-1");
        } else {
            bw.write(sb + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
