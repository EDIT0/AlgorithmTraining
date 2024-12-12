package com.my.codingtest.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 해시맵_정렬_귤_고르기 {

    public static void main(String[] args) {
        int k1 = 6;
        int[] tangerine1 = {1, 3, 2, 5, 4, 5, 2, 3};
        // 3

        int k2 = 4;
        int[] tangerine2 = {1, 3, 2, 5, 4, 5, 2, 3};
        // 2

        int k3 = 2;
        int[] tangerine3 = {1, 1, 1, 1, 2, 2, 2, 3};
        // 1

        System.out.println(solution(k3, tangerine3));
    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> countHashMap = new HashMap<>();

        for(int i=0;i<tangerine.length;i++) {
            if(countHashMap.containsKey(tangerine[i])) {
                countHashMap.put(tangerine[i], countHashMap.get(tangerine[i]) + 1);
            } else {
                countHashMap.put(tangerine[i], 1);
            }
        }

        // HashMap을 리스트로 변경 후 정렬
        ArrayList<Integer> amountList = new ArrayList<>(countHashMap.values());
        Collections.sort(amountList, Collections.reverseOrder());

        for(int i=0;i<amountList.size();i++) {
            k -= amountList.get(i);
            if(k > 0) {
                continue;
            } else {
                answer = i+1;
                break;
            }
        }

        return answer;
    }

}
