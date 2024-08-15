package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s2_9184 {

    static int[][][] arr = new int[51][51][51]; // -50 ≤ a, b, c ≤ 50

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;
            while (true) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if(a == -1 && b == -1 && c == -1) {
                    break;
                }

                if(a < 0 || b < 0 || c < 0) {
                    bw.write( "w(" + a + ", " + b + ", " + c + ") = 1\n");
                } else {
                    bw.write( "w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
                }
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }

    }

    public static int w(int a, int b, int c) {

        if(arr[a][b][c] != 0) {
            return arr[a][b][c];
        }


        if(a<=0||b<=0||c<=0) {
            return 1;
        }

        if(a>20 || b>20 || c>20) {
            arr[a][b][c] = w(20, 20, 20);
            return arr[a][b][c];
        }

        if(a < b && b < c) {
            arr[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            return arr[a][b][c];
        }

        arr[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return arr[a][b][c];
    }
}
