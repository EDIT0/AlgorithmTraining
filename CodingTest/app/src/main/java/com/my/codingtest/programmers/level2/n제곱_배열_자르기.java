package com.my.codingtest.programmers.level2;

import java.util.*;

public class n제곱_배열_자르기 {

    public static void main(String[] args) {
        int n1 = 3;
        int left1 = 2;
        int right1 = 5;
        // [3,2,2,3]

        int n2 = 4;
        int left2 = 7;
        int right2 = 14;
        // [4,3,3,3,4,4,4,4]

        System.out.println(Arrays.toString(solution(n1, left1, right1)));
    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = {};

//        long index = 0;
//        int answerIndex = 0;
//        answer = new int[n*n];
//
//        for(int i=1;i<=n;i++) {
//            for(int j=1;j<=n;j++) {
//                if(i < j) { //  && index >= left && index <= right
//                    answer[answerIndex] = j;
//                    answerIndex += 1;
//                    System.out.print(j + ", ");
//                } else if(i >= j) { //  && index >= left && index <= right
//                    answer[answerIndex] = i;
//                    answerIndex += 1;
//                    System.out.print(i + ", ");
//                }
//                index += 1;
//            }
//        }
//        System.out.println();

        answer = new int[(int) (right-left+1)];

        for(int i=0;i<=right-left;i++) {
            long group = (left+i) / n;
            long r = (left+i) % n;
            if(group < r) {
                answer[i] = (int) (r+1);
            } else {
                answer[i] = (int) (group+1);
            }
        }

        return answer;
    }

}
