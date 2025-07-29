package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 투포인터_s1_2531 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 벨트에 놓인 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] arr = new int[N+k];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0;i<k;i++) {
            arr[N+i] = arr[i];
        }

        int[] type = new int[d+1];
        int max = 0;
        int currentMax = max;

        for(int i=0;i<k;i++) {
            if (type[arr[i]] == 0) { // 0인것들이 새로운 초밥 종류
                currentMax += 1;
            }
            type[arr[i]] += 1;
        }

        int tmpMax = currentMax;
        if(type[c] == 0) { // 쿠폰 초밥을 먹었는지 안먹었는지 확인
            tmpMax += 1;
        }
        max = tmpMax;

        for(int i=1;i<N;i++) {
            int remove = arr[i-1];
            int add = arr[i+k-1];

            type[remove] -= 1;
            if(type[remove] == 0) { // 0이면 초밥 종류 삭제
                currentMax -= 1;
            }

            if(type[add] == 0) { // 0이면 초밥 종류 추가
                currentMax += 1;
            }
            type[add] += 1;

            int tmpMax2 = currentMax; // 다른곳으로 옮겨서 쿠폰 초밥 확인 / currentMax는 유지
            if(type[c] == 0) {
                tmpMax2 += 1;
            }

            if(max < tmpMax2) {
                max = tmpMax2;
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
