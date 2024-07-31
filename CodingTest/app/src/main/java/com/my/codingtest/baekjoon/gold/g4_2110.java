package com.my.codingtest.baekjoon.gold;

import java.io.*;
import java.util.*;

public class g4_2110 {
    public static void main(String[] args) {

        // 200,000,000

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];
            for(int i=0;i<N;i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            bw.write(binary1(C, arr) + "");

            bw.flush();
            bw.close();
            br.close();
        } catch (Exception e) {

        }

    }

    public static long binary1(int key, int[] arr) {
        long start = 1;
        long end = arr[arr.length - 1];
        long mid;

        long result = 0;

        while (start <= end) {
            mid = (start + end) / 2; // mid는 거리가 된다.

            long count = 0; // 공유기 설치한 집 수
            long min = Integer.MAX_VALUE; // 공유기가 설치된 집 간의 가장 가까운 거리
            int l = 1; // for문 안에서 공유기가 설치된 집과 그 다음 집을 비교해야 하므로 마지막으로 설치한 집의 위치를 기억하기 위해 사용
            for(int i=0;i<arr.length;i++) {
                if(i == 0) {
                    count++; // 첫 집은 무조건 설치
                } else {
                    int tmp = arr[i] - arr[i - l]; // 집 사이의 거리
                    if(tmp >= mid) { // 현재 거리가 기준거리(mid)보다 크거나 같으면 공유기 설치
                        count++;
                        if(tmp < min) {
                            min = tmp;
                        }
                        l = 1; // 설치하였으므로 바로 이전 집과 비교하기위해 1로 초기화
                    } else {
                        l++; // 설치하지 않고 넘어가면 마지막으로 설치한 집을 기억하기 위해 l +1
                    }
                }
            }

            if(count == key) {
                result = min;
                start = mid + 1;
            } else if(count < key) {
                end = mid - 1;
            } else if(count > key) {
                result = min; // 설치된 공유기가 갯수가 가지고 있는 공유기 갯수보다 많이 설치되었을 경우에도 결과는 저장 후
                start = mid + 1; // 거리(mid)를 더 늘려서 시도한다.
            }
        }

        return result;
    }
}
