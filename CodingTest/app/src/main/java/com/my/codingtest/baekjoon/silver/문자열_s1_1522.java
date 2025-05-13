package com.my.codingtest.baekjoon.silver;

import java.io.*;

public class 문자열_s1_1522 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String input = br.readLine();
            int aCount = 0;
            int bCount = Integer.MAX_VALUE;
            int currentBCount = 0;

            for(int i=0;i<input.length();i++) {
                if(input.charAt(i) == 'a') {
                    aCount += 1;
                }
            }

            input += input;

            for(int i=0;i<input.length()/2;i++) {
                currentBCount = 0;
                for(int j=i;j<i+aCount;j++) {
                    if(input.charAt(j) == 'b') {
                        currentBCount += 1;
                    }
                }
                if(bCount > currentBCount) {
                    bCount = currentBCount;
                }
            }

            bw.write(bCount + "");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
