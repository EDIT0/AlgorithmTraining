package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class 이분탐색_g2_15732 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 상자의 갯수 (1 ≤ N ≤ 1,000,000)
        int K = Integer.parseInt(st.nextToken()); // 규칙의 갯수 K(1 ≤ K ≤ 10,000)
        int D = Integer.parseInt(st.nextToken()); // 도토리의 갯수 (1 ≤ D ≤ 1,000,000,000)

        Model[] kArr = new Model[K];

        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            kArr[i] = new Model(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        long answer = binary(kArr, N, D);

        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static long binary(Model[] kArr, int N, int D) {
        int low = 1;
        int high = N;
        long returnValue = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            long dCount = 0; // 넣은 도토리 갯수

            for(int i=0;i<kArr.length;i++) {
                if(mid < kArr[i].A) {
                    dCount += 0; // 시작할수 있는 박스보다 작으면 넣을 수 있는 도토리 갯수 0
                } else if(mid >= kArr[i].B) {
                    dCount += ((kArr[i].B - kArr[i].A) / kArr[i].C + 1); // 최대로 넣을 수 있는 도토리 갯수
                } else if(kArr[i].A <= mid && mid < kArr[i].B) {
                    dCount += ((Math.min(mid, kArr[i].B) - kArr[i].A) / kArr[i].C + 1); // A ~ B 사이에 있는 도토리 넣을 수 있는 갯수
                }
            }

            System.out.println("dCount: " + dCount + " / mid: " + mid);

            if(dCount < D) { // 넣어야하는 도토리 D보다 작으면 범위를 높인다.
                low = mid + 1;
            } else if(dCount >= D) { // 넣어야하는 도토리 보다 크거나 같으면 범위를 줄인다.
                high = mid - 1;
                returnValue = mid; // 마지막 도토리가 들어갈 수 있도록 같아도 최대한 범위를 줄여서 값 갱신
            }
        }

        return returnValue;
    }

    public static class Model {
        int A, B, C;

        Model(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }
}
