package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s2_1541 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String inputString = br.readLine();

        String[] str = inputString.split("-");

        int answer = 0;

        answer += calSum(str[0]);

        for(int i=1;i<str.length;i++) {
            answer -= calSum(str[i]);
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calSum(String s) {
        String[] strArr = s.split("\\+");

        int sum = 0;
        for(int i=0;i<strArr.length;i++) {
            sum += Integer.parseInt(strArr[i]);
        }

        return sum;
    }
}
