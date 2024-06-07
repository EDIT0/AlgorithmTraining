package com.my.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b3_2720 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // 쿼터(Quarter, $0.25)의 개수, 25센트
        // 다임(Dime, $0.10)의 개수, 10센트
        // 니켈(Nickel, $0.05)의 개수, 5센트
        // 페니(Penny, $0.01)의 개수 1센트
        try {
            int[] moneyUnit = new int[] {25, 10, 5, 1};

            int caseNum = Integer.parseInt(br.readLine()); // 테스트케이스 수
            int[] totalCentArr = new int[caseNum]; // 총 센트 담을 배열
            String[] resultArr = new String[caseNum];

            // 각 케이스마다 총 센트 받기
            for(int i=0;i<caseNum;i++) {
                totalCentArr[i] = Integer.parseInt(br.readLine());
            }

            // 124, 25, 194
            for(int i=0;i<caseNum;i++) {
                StringBuilder str = new StringBuilder();

                for(int j=0;j<moneyUnit.length;j++) {
                    str.append(totalCentArr[i] / moneyUnit[j] + " ");
                    totalCentArr[i] %= moneyUnit[j];
                }
                resultArr[i] = str.toString();
            }

            for(int i=0;i<caseNum;i++) {
                bw.write(resultArr[i] + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }
    }
}
