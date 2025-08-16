package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 그리디_s2_16953 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int count = 0;
        while (B > A) {
            if(B % 2 == 0) {
                B /= 2;
            } else if(B % 10 == 1){
                B /= 10;
            } else {
                break;
            }
            count += 1;
        }
        if(B != A) {
            count = -1;
        } else {
            count += 1;
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
