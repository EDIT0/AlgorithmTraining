package com.my.codingtest.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 가장_가까운_같은_글자 {

    public static void main(String[] args) {
        String s1 = "banana";
        String s2 = "foobar";

        System.out.println(Arrays.toString(solution(s2)) + "");
    }

    public static int[] solution(String s) {
        int[] answer = {};
        answer = new int[s.length()];

        Map<String, Integer> hashMap = new HashMap<>();

        for (int i=0;i<s.length();i++) {
            if(hashMap.containsKey(String.valueOf(s.charAt(i)))) {
                int value = hashMap.get(String.valueOf(s.charAt(i)));
                int a = i - value; // 현재 위치에서 마지막 나온 위치를 뺀다.
                answer[i] = a;
            } else {
                answer[i] = -1;
            }
            hashMap.put(String.valueOf(s.charAt(i)), i); // 마지막으로 나온 위치 저장
        }

        return answer;
    }

}
