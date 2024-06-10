package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b3_3009 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;
            int[] arrX = new int[3];
            int[] arrY = new int[3];

            int x = -1; // 찾아야하는 x축
            int y = -1; // 찾아야하는 y축

            for(int i=0;i<3;i++) {
                st = new StringTokenizer(br.readLine());

                arrX[i] = Integer.parseInt(st.nextToken());
                arrY[i] = Integer.parseInt(st.nextToken());
            }

            if(arrX[0] == arrX[1]) { // 0번째와 1번째가 같다면 2번째 값이 x
                x = arrX[2];
            } else {
                if(arrX[0] == arrX[2]) { // 0번째와 2번째가 같다면 1번째 값이 x
                    x = arrX[1];
                } else {
                    x = arrX[0];
                }
            }

            if(arrY[0] == arrY[1]) { // 0번째와 1번째가 같다면 2번째 값이 x
                y = arrY[2];
            } else {
                if(arrY[0] == arrY[2]) { // 0번째와 2번째가 같다면 1번째 값이 x
                    y = arrY[1];
                } else {
                    y = arrY[0];
                }
            }

            bw.write(x + " " + y);

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }

}
