package com.my.codingtest.baekjoon.bronze;

import java.io.*;

public class 문자열_b1_10798 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String[] strArr = new String[5];
            int maxLength = 0;
            for(int i=0;i<5;i++) {
                String line = br.readLine();

                strArr[i] = line;

                if(maxLength < line.length()) {
                    maxLength = line.length();
                }
            }

            for(int i=0;i<5;i++) {
                StringBuilder sb = new StringBuilder(strArr[i]);
                for(int j=0;j<maxLength-strArr[i].length();j++) {
                    sb = sb.append(" ");
                }
                strArr[i] = sb.toString();
            }

            for(int i=0;i<maxLength;i++) {
                for(int j=0;j<strArr.length;j++) {
                    if(strArr[j].charAt(i) != ' ') {
                        bw.write(strArr[j].charAt(i));
                    }
                }
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
