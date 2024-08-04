package com.my.codingtest.test;

import static java.lang.Math.max;

import java.util.HashMap;
import java.util.Map;

// 최장 증가 부분 수열(LIS)
// 동적 계획법 (Dynamic Programming)
// 11053
public class lis_1 {
    public static void main(String[] args) {
        // {10, 20, 10, 30, 20, 50};
        // {5, 3, 1, 2, 7, 3};
        // {2, 1, 3, 5, 4};
        int[] arr = {10, 20, 10, 30, 20, 50};

        int[] result = new int[arr.length];

        for (int i=0; i<arr.length; i++){
            result[i] = 1;
            for (int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    result[i] = max(result[i], result[j] + 1);
                }
            }
        }

        Map<Integer, String> hashMap = new HashMap<>();
        for(int i=0;i<result.length;i++) {
            System.out.print(result[i] + " ");
            hashMap.put(result[i], "");
        }

        System.out.println();
        System.out.println(hashMap.size() + "");
    }
}
