package com.my.codingtest.programmers.level1;

public class 음양_더하기 {
    public static void main(String[] args) {
        int[] absolutes1 = {4,7,12};
        boolean[] signs1 = {true,false,true};
        // 9

        int[] absolutes2 = {1,2,3};
        boolean[] signs2 = {false,false,true};
        // 0

        System.out.println(solution(absolutes2, signs2) + "");
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 123456789;

        answer = 0;
        for(int i=0;i<absolutes.length;i++) {
            if(signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}
