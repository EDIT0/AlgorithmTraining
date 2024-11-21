package com.my.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;

public class 줄_서는_방법_순열 {

    public static void main(String[] args) {
        int n1 = 3;
        int k1 = 5;

        System.out.println(Arrays.toString(solution(n1, k1)));
    }

    public static int[] solution(int n, long k) {
        int[] answer = {};

        answer = new int[n];

        ArrayList<Integer> list = new ArrayList<>();
        long total = 1;
        for(int i=1;i<=n;i++) {
            list.add(i);
            total *= i;
        }

        k -= 1; // 0부터 시작하므로 -1

        int idx = 0;
        while(idx < n) {
            int t = n - idx;
            total /= t;
            int removedNum = list.remove((int) (k / total));
            answer[idx] = removedNum;
            idx += 1;
            k %= total; // 갱신
        }

        return answer;
    }

}
