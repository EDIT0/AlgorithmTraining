package com.my.codingtest.baekjoon.silver;

import java.io.*;

public class 문자열_s3_1515 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String strArr = br.readLine();

            int num = 1;
            int length = strArr.length();
            int index = 0;

            while (true) {
                char targetNum = strArr.charAt(index);
                for(int i=0;i<String.valueOf(num).length();i++) {
                    if(targetNum == String.valueOf(num).charAt(i)) {
                        index += 1;

                        if(length == index) {
                            break;
                        }

                        targetNum = strArr.charAt(index);
                    }
                }

                if(length == index) {
                    break;
                }

                num += 1;
            }

            bw.write(num + "");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }
}
