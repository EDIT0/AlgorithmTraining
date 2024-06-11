package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class b3_9063 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine());

            int[] arrX = new int[N];
            int[] arrY = new int[N];

            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                arrX[i] = Integer.parseInt(st.nextToken());
                arrY[i] = Integer.parseInt(st.nextToken());
            }

            if(N == 1) {
                bw.write("0");
            } else {
                for(int i=0;i<N;i++) {
                    if(maxX < arrX[i]) { // x축의 가장 큰 수 찾기
                        maxX = arrX[i];
                    }
                    if(maxY < arrY[i]) { // y축의 가장 큰 수 찾기
                        maxY = arrY[i];
                    }
                    if(minX > arrX[i]) { // x축의 가장 작은 수 찾기
                        minX = arrX[i];
                    }
                    if(minY > arrY[i]) { // y축의 가장 작은 수 찾기
                        minY = arrY[i];
                    }
                }
                int result = (maxX - minX) * (maxY - minY);
                bw.write(result + "");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e){

        }
    }

}
