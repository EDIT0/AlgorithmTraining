package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b1_11653 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int N = Integer.parseInt(br.readLine());

            while(N != 1){
                for(int i=1;i<N;i++){ // 1은 넣지 않는다.
                    if(N % (i+1) == 0) {
                        bw.write("" + (i+1) + "\n");
                        N /= (i+1);
                        break;
                    }
                }
            }

            bw.flush();
            bw.close();
            br.close();


        } catch (Exception e) {

        }
    }
}
