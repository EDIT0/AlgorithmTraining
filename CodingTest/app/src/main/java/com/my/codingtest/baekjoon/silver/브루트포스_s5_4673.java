package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 브루트포스_s5_4673 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        boolean[] board = new boolean[10001];

        for(int i=1;i<10001;i++) {
            int result = i;

            String s = String.valueOf(result);
            for(int j=0;j<s.length();j++) {
                result += Integer.parseInt(String.valueOf(s.charAt(j)));
            }
            if(result <= 10000) {
                board[result] = true;
            }
        }

        for(int i=1;i<board.length;i++) {
            if(!board[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
