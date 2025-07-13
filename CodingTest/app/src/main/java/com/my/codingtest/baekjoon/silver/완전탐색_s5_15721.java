package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 완전탐색_s5_15721 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int type = Integer.parseInt(br.readLine());

        int index = 2; // n - 1
        int count = 0;
        boolean flag = true;
        int sum = 0;

        while (flag) {
            int[] pattern = {0, 1, 0, 1};
            for(int i=0;i<4;i++) {
                if(pattern[i] == type) {
                    count += 1;
                }
                if(count == T) {
                    flag = false;
                    break;
                }
                sum += 1;
            }

            if(flag) {
                for(int i=0;i<index;i++) {
                    if(type == 0) {
                        count += 1;
                        if(count == T) {
                            flag = false;
                            break;
                        }
                    }
                    sum += 1;
                }
            }
            if(flag) {
                for(int i=0;i<index;i++) {
                    if(type == 1) {
                        count += 1;
                        if(count == T) {
                            flag = false;
                            break;
                        }
                    }
                    sum += 1;
                }
            }

            index += 1;
        }

        bw.write(sum%A + "");

        bw.flush();
        bw.close();
        br.close();
    }

}
