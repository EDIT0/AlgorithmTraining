package com.my.codingtest.baekjoon.bronze;

import java.io.*;
import java.util.*;

public class 기초수학_b2_5618 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static int[] numArr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        numArr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0;i<n;i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);

        for(int i=1;i<=numArr[0];i++) {
            boolean flag = true;
            for(int j=0;j<numArr.length;j++) {
                if(numArr[j] % i != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
