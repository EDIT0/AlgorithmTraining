package com.my.codingtest.programmers.level2;

import java.util.*;

public class 행렬의_곱셈 {

    public static void main(String[] args) {
        int[][] arr1_1 = {
                {1, 4},
                {3, 2},
                {4, 1}
        };
        int[][] arr2_1 = {
                {3, 3},
                {3, 3}
        };
        // {{15, 15}, {15, 15}, {15, 15}};

        int[][] arr1_2 = {
                {2, 3, 2},
                {4, 2, 4},
                {3, 1, 4}
        };
        int[][] arr2_2 = {
                {5, 4, 3},
                {2, 4, 1},
                {3, 1, 1}
        };
        // {{22, 22, 11}, {36, 28, 18}, {29, 20, 14}};

//        System.out.println(Arrays.toString(solution(arr1_1, arr2_1)));
        System.out.println(Arrays.toString(solution(arr1_2, arr2_2)));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};

        answer = new int[arr1.length][arr2[0].length];

        for(int k=0;k<arr1.length;k++) {
            for(int i=0;i<arr2[0].length;i++) {
                int sum = 0;
                for(int j=0;j<arr2.length;j++) {
                    sum += (arr1[k][j] * arr2[j][i]);
                }
                answer[k][i] = sum;
            }
        }


        System.out.println();
        for(int i=0;i<answer.length;i++) {
            for(int j=0;j<answer[0].length;j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

        return answer;
    }

}
