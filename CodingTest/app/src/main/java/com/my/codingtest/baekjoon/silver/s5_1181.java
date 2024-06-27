package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s5_1181 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());
            String[] strArr = new String[N];
            for(int i=0;i<N;i++) {
                String inputStr = br.readLine();
                strArr[i] = inputStr;
            }

            Arrays.sort(strArr, ((o1, o2) -> {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return Integer.compare(o1.length(), o2.length()); // -면 변경x / +면 변경o
                }
            }));

            for(int i=0;i<N;i++) {
                if(i > 0 && strArr[i].equals(strArr[i-1])) { // 정렬 후 같은 문자열 제거

                } else {
                    bw.write(strArr[i] + "\n");
                }
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
