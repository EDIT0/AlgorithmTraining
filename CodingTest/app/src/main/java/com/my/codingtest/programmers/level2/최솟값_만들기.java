package com.my.codingtest.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class 최솟값_만들기 {

    public static void main(String[] args) {
        int[] A1 = {1, 4, 2};
        int[] B1 = {5, 4, 4};

        int[] A2 = {1, 2};
        int[] B2 = {3, 4};

        System.out.println(solution(A1, B1));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);

        Integer[] integerArr = new Integer[B.length];
        for(int i=0;i<B.length;i++) {
            integerArr[i] = B[i];
        }

        /**
         * 양수 (> 0):
         * 첫 번째 객체(o1)가 두 번째 객체(o2)보다 크다고 판단.
         * 정렬 시 o2가 앞에 오고, o1이 뒤에 옵니다.
         *
         * 0:
         * 두 객체가 같다고 판단.
         * 정렬 순서가 유지됩니다 (정렬 알고리즘에 따라 달라질 수 있음).
         *
         * 음수 (< 0):
         * 첫 번째 객체(o1)가 두 번째 객체(o2)보다 작다고 판단.
         * 정렬 시 o1이 앞에 오고, o2가 뒤에 옵니다.
         */
        Arrays.sort(integerArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i=0;i<A.length;i++) {
            answer += (A[i] * integerArr[i]);
        }

        return answer;
    }

}
