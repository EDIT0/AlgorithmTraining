package com.my.codingtest.programmers.level2;

import java.util.Arrays;

public class 요격_시스템 {
    public static void main(String[] args) {
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        // 3, 1,2 / 4,5 / 11,12
        // 1,4 / 3,7 / 4,5 / 4,8 / 5,12 / 10,14 / 11,13
        // [1,2],3,4
        // 3,4,5,6,7
        // 4,5
        // [4,5],6,7,8
        // 5,6,7,8,9,10,[11,12]
        // 10,11,12,13,14
        // 11,12,13
        System.out.println(solution(targets));
    }

    public static int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> {
            return Integer.compare(o1[1], o2[1]);
        });

        int num = 0;
        for(int i=0;i<targets.length;i++) {
            if(targets[i][0] >= num) {
                answer += 1;
                num = targets[i][1];
            }
        }

        return answer;
    }
}
