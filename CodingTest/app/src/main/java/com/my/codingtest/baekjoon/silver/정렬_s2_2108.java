package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class 정렬_s2_2108 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        /**
         * 산술평균 : N개의 수들의 합을 N으로 나눈 값
         * 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
         * 최빈값 : N개의 수들 중 가장 많이 나타나는 값
         * 범위 : N개의 수들 중 최댓값과 최솟값의 차이
         * */

        Arrays.sort(arr);

        int totalSum = 0;
        for(int i=0;i<N;i++) {
            totalSum += arr[i];
        }
        int answer1 = (int) Math.round((double) totalSum / N);
        bw.write(answer1 + "\n");

        int answer2 = arr[arr.length / 2];
        bw.write(answer2 + "\n");

        int answer3 = 0;
        Model[] models = new Model[8001];
        for(int i=0;i<8001;i++) {
            models[i] = new Model(8001, 0);
        }
        for(int i=0;i<N;i++) {
            models[arr[i] + 4000] = new Model(arr[i] + 4000, models[arr[i] + 4000].count + 1);
        }

        Arrays.sort(models, (o1, o2) -> {
            if(o1.count > o2.count) {
                return -1;
            } else if(o1.count < o2.count) {
                return 1;
            } else {
                if(o1.num > o2.num) {
                    return 1;
                } else if(o1.num < o2.num) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

//        for(int i=0;i<models.length;i++) {
//            if(models[i].count != 0) {
//                System.out.println(models[i].num + " / " + models[i].count);
//            }
//        }

        if(models[0].count != models[1].count) {
            answer3 = models[0].num - 4000;
        } else {
            answer3 = models[1].num - 4000;
        }
        bw.write(answer3 + "\n");

        int answer4 = arr[arr.length - 1] - arr[0];
        bw.write(answer4 + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static class Model {
        int num;
        int count;

        Model(int n, int c) {
            num = n;
            count = c;
        }
    }
}