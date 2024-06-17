package com.my.codingtest.baekjoon.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class s4_1018 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            String[][] arr = new String[M][N];

            // 입력 받기
            for(int i=0;i<M;i++) {
                String input = br.readLine();
                for(int j=0;j<N;j++) {
                    arr[i][j] = String.valueOf(input.charAt(j));
                }
            }

//            int caseCount = (arr.length - 8 + 1) * (arr[0].length - 8 + 1); // 최대 만들 수 있는 판


            int w_s = 0; // 판에서 행의 시작 포인트
            int w_e = 7; // 판에서 행의 끝 포인트
            int h_s = 0; // 판에서 열의 시작 포인트
            int h_e = 7; // 판에서 열의 끝 포인트

            // 블랙을 기준으로 계산
            // 열로 보았을 때 블/화/블/화 식으로 진행되기 때문에 currentHeight로 현재 어떤 색깔이 가장 먼저 오는지 판단한다.
            // 홀수는 블랙, 짝수는 화이트
            int currentHeight = 1;
            int a = 1;

            ArrayList<Integer> minValuePerCaseList = new ArrayList<>(); // 각 케이스마다 최소값을 담을 리스트
            int count;

            while(true) {
                count = 0;
//                bw.write(h_s + " / " + h_e + " / " + w_s + " / " + w_e + "\n");
                for(int i=h_s;i<=h_e;i++) {
                    for(int j=w_s;j<=w_e;j++) {
//                        bw.write(arr[i][j] + " vs " + findBlackCase(a) + "\n");
                        if(!arr[i][j].equals(findBlackCase(a))) { // 색깔이 다르면 count한다.
                            count++;
                        }
                        a++;
                    }
                    // 한 행을 다 돌았으면 열이 변경되므로, 변경된 열에서 시작되는 행의 색깔 값을 변경
                    if(currentHeight == 1) {
                        currentHeight = 2;
                        a = 2;
                    } else {
                        currentHeight = 1;
                        a = 1;
                    }
                }

                minValuePerCaseList.add(Math.min(count, 64 - count));

                w_s++;
                w_e++;

                if(w_e > arr[0].length - 1) { // 행의 끝에 도달했는가?
                    if(h_e > arr.length - 1) { // 열의 끝에 도달했는가?
                        break;
                    } else { // 열의 끝에 도달하지 않았다면.. 행 값 초기화 및 열 값은 +1
                        w_s = 0;
                        w_e = 7;
                        h_s++;
                        h_e++;
                        if(h_e > arr.length - 1) { // 열 값이 최대 범위를 넘어가면 break
                            break;
                        }
                    }
                }
            }

            Collections.sort(minValuePerCaseList);
//            for(int i=0;i<minValuePerCaseList.size() - 1;i++) {
//                bw.write(minValuePerCaseList.get(i) + " / ");
//            }

            bw.write(minValuePerCaseList.get(0) + "");


            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String findBlackCase(int value) {
        if(value%2!=0) {
            return "B";
        } else {
            return "W";
        }
    }
}
