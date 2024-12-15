package com.my.codingtest.programmers.level2;

import java.util.HashMap;

public class 해시_롤케이크_자르기 {

    public static void main(String[] args) {
        int[] topping1 = {1, 2, 1, 3, 1, 4, 1, 2};
        // 2
        // [1, 2, 1, 3], [1, 4, 1, 2] 또는 [1, 2, 1, 3, 1], [4, 1, 2]

        int[] topping2 = {1, 2, 3, 1, 4};
        // 0

        System.out.println(solution(topping1));
    }

    public static int solution(int[] topping) {
        int answer = 0;

        /**
         * 1 ≤ topping의 길이 ≤ 1,000,000
         * 1 ≤ topping의 원소 ≤ 10,000
         */
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        for(int i=0;i<topping.length;i++) {
            int count = hashMap2.getOrDefault(topping[i], 0);
            hashMap2.put(topping[i], count + 1);
        }

        for(int i=0;i<topping.length;i++) {
            int count = hashMap2.getOrDefault(topping[i], 0);
            if(count-1 == 0) {
                hashMap2.remove(topping[i]);
            } else {
                hashMap2.put(topping[i], count - 1);
            }

            hashMap1.put(topping[i], hashMap1.getOrDefault(topping[i], 0) + 1);

            if(hashMap1.size() == hashMap2.size()) {
                answer += 1;
            }
            System.out.println(hashMap1.size() + " / " + hashMap2.size());
        }

        // 시간 초과
//        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
//        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
//        for(int i=1;i<=topping.length;i++) {
//            hashMap1.clear();
//            hashMap2.clear();
//            for(int j=1;j<=topping.length;j++) {
//                if(i < j) {
//                    hashMap2.put(topping[j-1], 1);
//                } else {
//                    hashMap1.put(topping[j-1], 1);
//                }
//            }
//            if(hashMap1.size() == hashMap2.size()) {
//                answer += 1;
//            }
//            System.out.println(hashMap1.size() + " / " + hashMap2.size());
//        }


        return answer;
    }

}
