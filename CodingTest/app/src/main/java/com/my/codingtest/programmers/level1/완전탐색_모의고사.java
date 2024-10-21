package com.my.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 완전탐색_모의고사 {

    public static void main(String[] args) {
        int[] answers1 = {1,2,3,4,5};
        // 1

        int[] answers2 = {1,3,2,4,2};
        // 1,2,3

        System.out.println(Arrays.toString(solution(answers2)) + "");
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};

        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        ArrayList<Pair> pairList = new ArrayList<>();
        for(int i=0;i<patterns.length;i++) {
            pairList.add(new Pair(i+1, 0));
        }

        for(int i=0;i<answers.length;i++) {
            int currentAnswer = answers[i];
            int pattern1Index = i%patterns[0].length;
            int pattern2Index = i%patterns[1].length;
            int pattern3Index = i%patterns[2].length;

            if(currentAnswer == patterns[0][pattern1Index]) {
                pairList.get(0).number = 1;
                pairList.get(0).count = pairList.get(0).count + 1;
            }
            if(currentAnswer == patterns[1][pattern2Index]) {
                pairList.get(1).number = 2;
                pairList.get(1).count = pairList.get(1).count + 1;
            }
            if(currentAnswer == patterns[2][pattern3Index]) {
                pairList.get(2).number = 3;
                pairList.get(2).count = pairList.get(2).count + 1;
            }
        }

        Collections.sort(pairList, ((o1, o2) -> {
            if(o2.count.compareTo(o1.count) == 0) { // 서로 같으면 Number로 오름차순 정렬
                return o1.number.compareTo(o2.number);
            }
            return o2.count.compareTo(o1.count); // 서로 다르면 count로 내림차순 정렬
        }));

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0;i<pairList.size();i++) {
            if(pairList.get(0).count <= pairList.get(i).count) {
                result.add(pairList.get(i).number);
            }
        }

        answer = new int[result.size()];
        for(int i=0;i<result.size();i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static class Pair {
        Integer number;
        Integer count;

        Pair(int n, int c) {
            number = n;
            count = c;
        }
    }

}
