package com.my.codingtest.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 추억_점수 {

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}
        };

        System.out.println(Arrays.toString(solution(name, yearning, photo)) + "");
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};

        answer = new int[photo.length];

        Map<String, Integer> hashMap = new HashMap<>();

        for(int i=0;i<name.length;i++) {
            hashMap.put(name[i], yearning[i]);
        }

        for(int i=0;i< photo.length;i++) {
            int sum = 0;
            for(int j=0;j<photo[i].length;j++) {
                Integer num = hashMap.get(photo[i][j]);
                if(num != null) {
                    sum += num.intValue();
                }
            }
            answer[i] = sum;
        }

        return answer;
    }
}
