package com.my.codingtest.programmers.level2;

import java.util.ArrayList;

public class LRU_캐시_KAKAO {

    public static void main(String[] args) {
        int cacheSize1 = 3;
        String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        // 50

        int cacheSize2 = 3;
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        // 21

        int cacheSize3 = 2;
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        // 60

        int cacheSize4 = 5;
        String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        // 52

        int cacheSize5 = 2;
        String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        // 16

        int cacheSize6 = 0;
        String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        // 25

        int cacheSize7 = 2;
        String[] cities7 = {"a", "a", "a", "b", "b", "b", "c", "c", "c"};
        // 21

        System.out.println(solution(cacheSize1, cities1) + "");
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        ArrayList<String> disk = new ArrayList<>();

        if(cacheSize == 0) {
            answer = cities.length * 5;
            return answer;
        }

        for(int i=0;i<cities.length;i++) {
            String city = cities[i].toUpperCase();

            if(disk.contains(city) && disk.size() < cacheSize) {
                disk.remove(city);
                disk.add(0, city);
                answer += 1;
            } else if(disk.contains(city) && disk.size() >= cacheSize) {
                disk.remove(city);
                disk.add(0, city);
                answer += 1;
            } else if(!disk.contains(city) && disk.size() >= cacheSize) {
                disk.remove(cacheSize - 1);
                disk.add(0, city);
                answer += 5;
            } else {
                disk.add(0, city);
                answer += 5;
            }

            for(int j=0;j<disk.size();j++) {
                System.out.print(disk.get(j) + " ");
            }
            System.out.println();
        }


        return answer;
    }

}
