package com.my.codingtest.programmers.level1;

public class 없는_숫자_더하기 {
    public static void main(String[] args) {
        int[] numbers1 = {1,2,3,4,6,7,8,0};

        int[] numbers2 = {5,8,4,0,6,7,9};

        System.out.println(solution(numbers2) + "");
    }

    public static int solution(int[] numbers) {
        int answer = 0;

        int[] arr = new int[10];

        for(int i=0;i<numbers.length;i++) {
            arr[numbers[i]] += 1;
        }

        for(int i=0;i<arr.length;i++) {
            if(arr[i] == 0) {
                answer += i;
            }
        }

        return answer;
    }
}
