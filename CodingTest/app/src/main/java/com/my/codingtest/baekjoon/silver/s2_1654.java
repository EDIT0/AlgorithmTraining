package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s2_1654 {
    public static void main(String[] args) {

        // 200,000,000

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[] arr = new int[K];
            for(int i=0;i<K;i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            long result = binary1(N, arr);

            bw.write(result + " ");

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }
    }

    public static long binary1(int key, int[] arr) {
        long start = 1; // 길이는 0이 될 수 없기 때문에 1부터 돈다.
        long end = arr[arr.length - 1];
        long mid;

        long result = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            long sum = 0;
            for(int i=0;i<arr.length;i++) {
                sum += (arr[i] / mid);
            }

            // break없이 while 조건이 안맞을 때 까지 돈다.
            if(sum == key) {
                result = mid; // N과 Sum 값이 맞을 때의 최대값
                start = mid + 1; // while 조건이 맞지 않을 때 까지 만들 수 있는 길이를 찾으면 최대값이 나온다.
            } else if(sum < key) { // 이 때는 만들 수 있는 선이 N보다 더 작기 때문에 result 값 업데이트 X
                end = mid - 1;
            } else {
                result = mid; // 이 때는 만들 수 있는 선이 N보다 더 크기 때문에 result 값 업데이트 O
                start = mid + 1;
            }
        }

        return result;
    }
}
