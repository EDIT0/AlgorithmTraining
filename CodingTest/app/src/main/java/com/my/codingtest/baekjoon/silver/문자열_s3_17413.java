package com.my.codingtest.baekjoon.silver;

import java.io.*;

public class 문자열_s3_17413 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String input = br.readLine();

            boolean isKey = false;
            StringBuilder sb = new StringBuilder();
            StringBuilder currentWord = new StringBuilder();

            for(int i=0;i<input.length();i++) {
                char word = input.charAt(i);
                if(word == '<') {
                    isKey = true;
                    sb.append(currentWord.reverse());
                    currentWord = new StringBuilder();
                    currentWord.append("<");
                    continue;
                } else if(word == '>') {
                    isKey = false;
                    currentWord.append(">");
                    sb.append(currentWord);
                    currentWord = new StringBuilder();
                    continue;
                }

                if(!isKey && word == ' ') {
                    sb.append(currentWord.reverse() + " ");
                    currentWord = new StringBuilder();
                } else {
                    currentWord.append(word);
                }
            }

            sb.append(currentWord.reverse());

            bw.write(sb.toString());

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
