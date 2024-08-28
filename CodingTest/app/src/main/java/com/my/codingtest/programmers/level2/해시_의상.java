package com.my.codingtest.programmers.level2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class 해시_의상 {

    public static void main(String[] args) {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        String[][] clothes2 = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };

        System.out.println(solution(clothes2) + "");
    }

    public static int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> haspMap = new HashMap<>();

        for(int i=0;i<clothes.length;i++) {
            if(haspMap.containsKey(clothes[i][1])) {
                haspMap.put(clothes[i][1], haspMap.get(clothes[i][1]) + 1);
            } else {
                haspMap.put(clothes[i][1], 1);
            }
        }

        int sum = 1;
        Iterator<Map.Entry<String, Integer>> iterator = haspMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            int value = (int) entry.getValue();
            sum *= value + 1; // 해당 값이 포함되지 않는 경우(즉, 선택되지 않는 경우)도 고려하기 위함 / 가능한 모든 경우의 수를 계산
        }


        answer = sum - 1; // 아무것도 선택되지 않은 경우 1 빼기

        return answer;
    }
}