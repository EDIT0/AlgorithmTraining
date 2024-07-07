package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s3_11478 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String S = br.readLine();
            int length = S.length();

            int repeat = 0;

            Map<String, Integer> hashMap = new HashMap(); // 중복 제거

            while (repeat < length) { // 0과 문자열 길이 비교
                String str = S;
                int unit = repeat + 1;
                for(int i=0;i<length - repeat;i++) { // ababc로 예를 들면 5,4,3,2,1 만큼 돈다.
//                    bw.write(str.substring(i, i + unit) + " ");
                    hashMap.put(str.substring(i, i + unit), 0);
                }

                repeat++;
            }

            bw.write(hashMap.size() + "");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }

}
