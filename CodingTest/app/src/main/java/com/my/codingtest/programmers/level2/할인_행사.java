package com.my.codingtest.programmers.level2;

import java.util.*;

public class 할인_행사 {

    public static void main(String[] args) {
        String[] want1 = {"banana", "apple", "rice", "pork", "pot"};
        int[] number1 = {3, 2, 2, 2, 1};
        String[] discount1 = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        // 3

        String[] want2 = {"apple"};
        int[] number2 = {10};
        String[] discount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        // 0

        System.out.println(solution(want1, number1, discount1));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> wantNumberHashMap = new HashMap<>();
        HashMap<String, Integer> eachResultHashMap = new HashMap<>();

        for(int i=0;i<number.length;i++) {
            wantNumberHashMap.put(want[i], number[i]);
        }

        for(int i=0;i<discount.length-9;i++) {
            for(int j=i;j<i+10;j++) {
                // number 원소의 합은 10이므로 해당되지 않는 discount 항목은 넣지 않는다.
                if(!wantNumberHashMap.containsKey(discount[j])) {
                    eachResultHashMap.clear();
                    break;
                } else {
                    eachResultHashMap.put(discount[j], eachResultHashMap.getOrDefault(discount[j], 0) + 1);
                }
            }

            if(!eachResultHashMap.isEmpty()) {
                boolean key = false;
                for(int j=0;j<wantNumberHashMap.size();j++) {
                    if(wantNumberHashMap.get(want[j]) != eachResultHashMap.get(want[j])) {
                        key = false;
                        break;
                    } else {
                        key = true;
                    }
                }
                eachResultHashMap.clear();
                if(key) {
                    answer += 1;
                }
            }
        }

        return answer;
    }

}
