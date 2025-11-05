package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s5_1789 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        long S = Long.parseLong(br.readLine());

        long index = 1;
        long sum = 0;
        long answer = 0;
        while (true) {
            if(S < sum) {
                bw.write(answer - 1 + "");
                break;
            } else if(S == sum) {
                bw.write(answer + "");
                break;
            }
            sum += index;
            index += 1;
            answer += 1;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
