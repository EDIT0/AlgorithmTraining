package com.my.codingtest.programmers.level2;

import java.util.Arrays;

public class 정렬_H_Index {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        // 3

        /**
         * [1,10,11] return 2
         * 11/1 10/2 1/3
         * [10,11] return 2
         * [0,0,0,0,0] return 0
         * 문제 이해
         * https://www.ibric.org/bric/trend/bio-series.do?mode=series_view&newsArticleNo=8802417&articleNo=8882714&beforeMode=latest_list#!/list
         */
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;

        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        // 내림차순
        Arrays.sort(arr, (o1, o2) -> {
            return o2 - o1;
        });

        for(int i=1;i<=arr.length;i++) {
            if(arr[i-1] >= i) {
                answer = i;
            } else {
                break;
            }
        }


        return answer;
    }

}
