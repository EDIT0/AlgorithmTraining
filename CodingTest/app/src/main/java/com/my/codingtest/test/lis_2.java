package com.my.codingtest.test;

import java.util.ArrayList;

// 12015
public class lis_2 {
    public static void main(String[] args) {
        // {10, 20, 10, 30, 20, 50};
        // {5, 3, 1, 2, 7, 3};
        // {2, 1, 3, 5, 4};
        int[] arr = {2, 1, 3, 5, 4};

        ArrayList<Integer> result = new ArrayList<Integer>();

        result.add(arr[0]);

        // result 리스트를 순서 보장 하면서 이분탐색을 돌린다.
        for(int i=1;i<arr.length;i++) {
            if(result.get(result.size() - 1) < arr[i]) { // result 리스트의 마지막 값보다 arr[i] 값이 크면 result 리스트의 마지막에 arr[i]를 추가만 한다.
                result.add(arr[i]);


//                System.out.println("1. " + arr[i]);
//
//                System.out.print("1. ");
//                for(int z=0;z<result.size();z++) {
//                    System.out.print(result.get(z) + " ");
//                }
//                System.out.println();
            } else {
                int value = binary1(arr[i], result);
                result.set(value, arr[i]);


//                System.out.println("2. " + arr[i]);
//
//                System.out.print("2. ");
//                for(int z=0;z<result.size();z++) {
//                    System.out.print(result.get(z) + " ");
//                }
//                System.out.println();
            }
        }

        for(int i=0;i<result.size();i++) {
            System.out.print(result.get(i) + " ");
        }

    }

    public static int binary1(int key, ArrayList<Integer> arrList) {
        int start = 0;
        int end = arrList.size() - 1;
        int mid;

        int result = -1;
        while (start <= end) {
            mid = (start + end) / 2;

            if(arrList.get(mid) == key) {
                // 값이 같으면 mid 자리에 값을 교체해도되고 안해도된다.
                return mid;
            } else if(arrList.get(mid) < key) {
                // arrList.get[mid]보다 key가 크다는 것은 key 값이 더 뒤에 위치하여야 한다는 것이기 때문에 result에 mid를 저장하지 않는다.
                start = mid + 1;
            } else if(arrList.get(mid) > key) {
                result = mid; // arrList.get[mid]보다 key가 작기 때문에 현재 mid의 위치에 result가 들어갈 가능성이 있다.
                end = mid - 1;
            }
        }

        return result;
    }
}
