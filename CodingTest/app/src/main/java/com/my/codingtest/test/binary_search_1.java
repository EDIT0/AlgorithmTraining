package com.my.codingtest.test;

import java.util.HashMap;

public class binary_search_1 {

    public static void main(String[] args) {
        // 이분탐색은 배열이 정렬되어 있어야 함.
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

        int result = binary(3, arr);
        if(result == Integer.MIN_VALUE) {
            System.out.println("찾는 값 없음");
        } else {
            System.out.println(result);
        }

        HashMap hashMap = new HashMap<String, Boolean>();
        hashMap.put("a", true);
        hashMap.put("b", false);
        hashMap.put("a", false);

        hashMap.forEach((key, value) -> {
            System.out.println("H " + key + " / " + value);
        });
    }

    public static int binary(int key, int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid;


        while (start <= end) {
            mid = (start + end) / 2;
            if(arr[mid] == key) {
                return mid;
            } else if(arr[mid] < key) {
                start = mid + 1;
            } else if(arr[mid] > key) {
                end = mid - 1;
            }
        }

        return Integer.MIN_VALUE;
    }

}
