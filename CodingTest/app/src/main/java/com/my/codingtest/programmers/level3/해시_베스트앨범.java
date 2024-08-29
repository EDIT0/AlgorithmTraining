package com.my.codingtest.programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 해시_베스트앨범 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)) + "");
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> hashMap2 = new HashMap<>();

        for(int i=0;i<plays.length;i++) {
            if(hashMap.containsKey(genres[i])) {
                hashMap.put(genres[i], hashMap.get(genres[i]) + plays[i]);

                Map<Integer, Integer> map = hashMap2.get(genres[i]);
                map.put(i, plays[i]);
                hashMap2.put(genres[i], map);
            } else {
                hashMap.put(genres[i], plays[i]);
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                hashMap2.put(genres[i], map);
            }
        }

        // 재생횟수 합으로 가장 큰 장르 꺼내기
        Comparator<Map.Entry<String, Integer>> comparator1 = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        };

        // 재생횟수 많은 장르 순 (modelList)
        ArrayList<Model> modelList = new ArrayList<>();
        int hashMapSize = hashMap.size();
        for(int i=0;i<hashMapSize;i++) {
            Map.Entry<String, Integer> maxEntry = Collections.max(hashMap.entrySet(), comparator1);
            modelList.add(new Model(maxEntry.getKey(), maxEntry.getValue()));
            hashMap.remove(maxEntry.getKey());
        }

        // 같은 장르에서 재생횟수 순서 구하기
        Comparator<Map.Entry<Integer, Integer>> comparator2 = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        };

        Map<String, ArrayList<Integer>> result = new HashMap<>();
        Iterator<Map.Entry<String, Map<Integer, Integer>>> iterator2 = hashMap2.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, Map<Integer, Integer>> entry = iterator2.next();

            int repeat = 0;
            if(entry.getValue().size() == 1) {
                repeat = 1;
            } else {
                repeat = 2;
            }

            for(int i=0;i<repeat;i++) {
                Map.Entry<Integer, Integer> maxEntry = Collections.max(entry.getValue().entrySet(), comparator2);

                if(result.get(entry.getKey()) == null) {
                    ArrayList<Integer> tmp = new ArrayList<>();
                    tmp.add(maxEntry.getKey());
                    result.put(entry.getKey(), tmp);
                } else {
                    ArrayList<Integer> tmp = result.get(entry.getKey());
                    tmp.add(maxEntry.getKey());
                    result.put(entry.getKey(), tmp);
                }

                entry.getValue().remove(maxEntry.getKey());
            }
        }


        // 정답 추출
        ArrayList<Integer> resultList = new ArrayList<>();
        for(int i=0;i<modelList.size();i++) {

            int arraySize = result.get(modelList.get(i).a).size();

            if(arraySize == 1) {
                resultList.add(result.get(modelList.get(i).a).get(0));
            } else {
                resultList.add(result.get(modelList.get(i).a).get(0));
                resultList.add(result.get(modelList.get(i).a).get(1));
            }
        }


        answer = resultList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    static class Model {
        String a;
        int b;
        Model(String a, int b) {
            this.a = a;
            this.b = b;
        }

        public String getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}
