package com.my.codingtest.baekjoon.silver;

import java.io.*;
import java.util.*;

public class s4_10816 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st;

            int N = Integer.parseInt(br.readLine());
            int[] arrN = new int[N];
            st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>(); // 각 N의 수들에 대해 중복 값이 있는 만큼 value에 +1 시켜준다.
            for(int i=0;i<N;i++) {
                arrN[i] = Integer.parseInt(st.nextToken());
                int newCount;
                int oldCount;
                try {
                    oldCount = hashMap.get(arrN[i]);
                    newCount = oldCount + 1; // 오류가 나오지 않는다면 이미 값이 있는 것이기 때문에 +1
                } catch (NullPointerException e) {
                    newCount = 1; // 초기 값은 1
                }

                hashMap.put(arrN[i], newCount);
            }

            int M = Integer.parseInt(br.readLine());
            int[] arrM = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++) {
                arrM[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrN);

            for(int i=0;i<M;i++) {
                if(binarySearch(arrM[i], arrN)) {
                    bw.write(hashMap.get(arrM[i]) + " "); // 중복값이 몇 번 나왔는지 hashMap value를 통해 알 수 있다.
                } else {
                    bw.write("0 ");
                }
            }

            bw.flush();
            bw.close();
            br.close();

        } catch (Exception e) {

        }

    }

    public static boolean binarySearch(int key, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if(arr[mid] == key) {
                return true;
            } else if(arr[mid] < key) {
                start = mid + 1;
            } else if(arr[mid] > key) {
                end = mid - 1;
            }
        }

        return false;
    }

}
