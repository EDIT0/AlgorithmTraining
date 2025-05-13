package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 구현_s5_10709 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int[][] arr = new int[H][W];

            for(int i=0;i<H;i++) {
                String line = br.readLine();
                boolean cloud = false;
                int num = 0;
                for(int j=0;j<W;j++) {
                    char c = line.charAt(j);

                    if(c == 'c') {
                        cloud = true;
                        num = 0;
                    } else if(cloud && c == '.') {
                        num += 1;
                    } else if(!cloud && c == '.') {
                        num = -1;
                    }

                    arr[i][j] = num;
                }
            }

            for(int i=0;i<H;i++) {
                for(int j=0;j<W;j++) {
                    bw.write(arr[i][j] + " ");
                }
                bw.write("\n");
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
