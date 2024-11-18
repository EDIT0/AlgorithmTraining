package com.my.codingtest.programmers.level1;

import java.util.Arrays;

public class 숫자_블록 {
    public static void main(String[] args) {
        int begin1 = 1;
        int end1 = 10;
        // {0, 1, 1, 2, 1, 3, 1, 4, 3, 5}

        int begin2 = 100000014;
        int end2 = 100000016;
        // 6, 5, 6250001

        System.out.println(Arrays.toString(solution(begin1, end1)));
    }

    public static int[] solution(long begin, long end) {
        int[] answer = {};

        int b = (int) begin;
        int e = (int) end;

        answer = new int[e - b + 1];

//        int idx = 0;
//
//        if(b == 1) {
//            answer[idx] = 0;
//            idx += 1;
//            b += 1;
//        }
//
//        for(int i=b;i<=e;i++) {
//            answer[idx] = 1;
//            for(int j=2;j<=Math.sqrt(i);j++) {
//                // 그렙시는 길이가 1,000,000,000인 도로에 1부터 10,000,000까지의 숫자가 적힌 블록들을 이용해 위의 규칙대로 모두 설치
//                if(i%j==0 && i/j <= 10000000) {
//                    answer[idx] = i/j;
//                    break;
//                }
//            }
//            idx += 1;
//        }

//        for(int i=e;i>=b;i--) {
//            answer[i-b] = 1;
//            int idx = 2;
//            for (int j=2;j*j<=i;j++) {
//                if(i == 1) {
//                    answer[i-b] = 0;
//                    break;
//                }
//                if(i%idx==0 && i/idx <= 10000000) {
//                    answer[i-b] = i/idx;
//                    break;
//                } else {
//                    idx += 1;
//                }
//            }
//        }

        for (int i=b;i<=e;i++) {
            if (i==1) {
                answer[i-b] = 0;
                continue;
            }
            answer[i-b] = 1;

            // 가장 큰 약수 찾기
            for (int j=2;j*j<=i;j++) {
                if (i%j==0) {
                    int quotient = i/j;
                    if (quotient <= 10000000) {
                        answer[i-b] = quotient;
                        break;
                    } else {
                        answer[i-b] = j;
                    }
                }
            }
        }

        return answer;
    }
}
