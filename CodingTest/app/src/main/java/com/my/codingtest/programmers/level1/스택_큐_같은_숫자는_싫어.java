package com.my.codingtest.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 스택_큐_같은_숫자는_싫어 {

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};

        System.out.println(Arrays.toString(solution(arr)) + "");
    }

    public static int[] solution(int[] arr) {
        int[] answer;

        int current = Integer.MIN_VALUE;
        ArrayList<Integer> resultList = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            if(current != arr[i]) {
                current = arr[i];
                resultList.add(current);
            }
        }

        answer = resultList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
