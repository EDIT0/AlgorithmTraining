package com.my.codingtest.programmers.level1;

import java.util.Arrays;

public class 제일_작은_수_제거하기 {

    public static void main(String[] args) {
        int[] arr1 = {4,3,2,1};
        int[] arr2 = {10};

        System.out.println(Arrays.toString(solution(arr1)) + "");
    }

    public static int[] solution(int[] arr) {
        int[] answer = {};

        answer = new int[arr.length == 1 ? 1 : arr.length-1];

        int[] tmpArr = arr.clone();

        if(arr.length == 1) {
            answer[0] = -1;
        } else {
            int min = Arrays.stream(arr).min().getAsInt();
            boolean check = false;
            for(int i=0;i<arr.length;i++) {
                int index = check ? i-1 : i;
                if(min != arr[i]) {
                    answer[index] = arr[i];
                } else {
                    check = true;
                }
            }
        }

        return answer;
    }

}
