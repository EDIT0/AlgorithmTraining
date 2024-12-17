package com.my.codingtest.programmers.level2;

import java.util.*;

public class 연속_부분_수열_합의_개수 {

    public static void main(String[] args) {
        int[] elements1 = {7,9,1,1,4};
        // 18

        System.out.println(solution(elements1));
    }

    public static int solution(int[] elements) {
        int answer = 0;

        HashMap<Integer, Boolean> hashMap = new HashMap<>();

        for(int i=0;i<elements.length;i++) {
            int group = i+1;
            for(int j=0;j<elements.length;j++) {
                int sum = 0;
                for(int k=j;k<j+group;k++) {
//                    int n = k;
//                    System.out.println(j +" / " + group + " / " + k);
                    sum += elements[k % elements.length];
//                    if(k >= elements.length) {
//                        n = Math.max(elements.length, k) - Math.min(elements.length, k);
//                    }
//                    sum += elements[n];
                }
                hashMap.put(sum, true);
//                System.out.println("합: " + sum + " / " + hashMap.size());
            }
//            System.out.println();
        }

        answer = hashMap.size();

        return answer;
    }

}
